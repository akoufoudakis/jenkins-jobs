def scanPipeline =
'''
def repoList = []
def prefix = 'https://www.github.com/kiegroup/'

node {
   stage('Read repo file') {
      configFileProvider([configFile(fileId: '9018a8b6-f91d-4da6-9007-03f68830e118', variable:'repoListFile')]) {
        def repoFile = readFile "$repoListFile"
        repoList = repoFile.readLines()
      }
   }
}

def branches = [:]

for (repo in repoList) {
    def branchName = 'Source Clear ' + "${repo}"
    println 'Repo before node ' + "${repo}"
    def repoName = "${repo}"
    branches[branchName] = {
        node {
            stage(branchName) {
                def url = "${prefix}" + "${repoName}"
                def jobName = 'srcclr/scan-' + "${repoName}"
                build job: "${jobName}", propagate: false, parameters: [[$class: 'StringParameterValue', name: 'URL', value: "${url}"]]
            }
        }
    }
}

parallel branches
'''

pipelineJob("parallel source clear scanning") {


  agent {
    label('master')
  }

  description("This is a pipeline, which runs source clear scanning jobs")

  parameters {
      stringParam('kie_version')
  }

  definition {
    cps {
      script("${scanPipeline}")
      sandbox()
    }
  }

}

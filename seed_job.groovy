def project = ""

def repoList = []
def prefix = 'https://www.github.com/kiegroup'

def scanPipeline =
'''
node('master') {
   stage('Read file') { // for display purposes
      repoList.add('drools')
      repoList.add('lienzo-core')
      repoList.add('lienzo-test')
   }
}

def branches = [:]

for (repo in repoList) {
    def branchName = 'Source Clear ' + "${repo}"

    branches[branchName] = {
        node ('master'){
            stage(branchName) {
                def url = "${prefix}" + "${repo}"
                build job: "matrix-job-${repo}", propagate: false,
                  parameters: [
                    [$class: 'StringParameterValue', name: 'project', value: "${repo}"],
                    [$class: 'StringParameterValue', name: 'URL', value: "${url}"]
                  ]
            }
        }
    }
}
parallel branches
'''

pipelineJob("parallel source clear scanning") {
  definition {
    cps {
      script("${scanPipeline}")
      sandbox()
    }
  }
}

job("matrix-job-${project}") {

  parameters {
    stringParam('project', '', 'The name of the project to be scanned')
    stringParam('URL', '', 'Repository URL')
  }


  steps {
    shell('echo "${URL}/" + '' + "${project}"')
  }

}

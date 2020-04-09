
def scanPipeline =
'''
def repoList = []
def prefix = 'https://www.github.com/kiegroup/'

node {
   stage('Read repo file') {
      git url: 'https://github.com/akoufoudakis/repo_bootstrap', branch: 'master'
      def repoListFilePath = './scripts/repo-list.txt'
      def repoListFile = readFile repoListFilePath
      repoList = repoListFile.readLines()
   }
}

def branches = [:]

for (repo in repoList) {
    def branchName = 'Source Clear ' + "${repo}"
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

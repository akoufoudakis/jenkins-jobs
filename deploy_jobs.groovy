job("generateJobs") {
  def repoFilePath = "./repos.txt"
  def repoFile = readFileFromWorkspace(repoFilePath);
  /*def repoList = repoFile.readLines*/
  /*for(repo in repoList) {
    def jobName = 'srcclr/scan-' + "${repo}"
    job(jobName) {
      parameters {
        stringParam('URL', '', 'Repository URL')
      }

      steps {
        shell('echo "${URL}"')
      }

    }
  }*/
  job("simpleJob") {
   steps{
    shell('echo "${repoFile}"')
    }
  }
}

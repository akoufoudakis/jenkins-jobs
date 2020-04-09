job("generateJobs") {

  def repoFilePath = "repo_bootstrap/repo-list.txt"
  def repoFile = readFileFromWorkspace(repoFilePath);
  def repoList = repoFile.split()
  for(repo in repoList) {
    def jobName = 'srcclr/scan-' + "${repo}"
    job(jobName) {
      parameters {
        stringParam('URL', '', 'Repository URL')
      }

      steps {
        shell('echo "${URL}"')
      }

    }
  }
}

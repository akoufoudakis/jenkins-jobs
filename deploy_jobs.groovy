job("generateJobs") {

  scm {
    git {
      remote {
        name('origin')
        url('https://github.com/akoufoudakis/repo_bootstrap')
      }
      branch('master')
    }
  }

  def repoFilePath = "./repo-list.txt"
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

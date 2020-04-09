job("generateJobs") {

  scm {
    git {
      remote {
        name('origin')
        url('https://github.com/akoufoudakis/repo_bootstrap')
      }
      branch('master')
      extensions {
        cleanAfterCheckout()
        relativeTargetDirectory('repo_bootstrap')
      }
    }
  }

  def repoFilePath = "./repo_bootstrap/repo-list.txt"
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

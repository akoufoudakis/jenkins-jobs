def repoList = ['lienzo-core',
                'lienzo-tests']

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

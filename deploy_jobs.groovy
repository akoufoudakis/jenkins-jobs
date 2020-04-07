def repoList = []
repoList.add('drools')
repoList.add('lienzo-core')
for(repo in repoList) {
  def jobName = 'scan' + "${repo}"
  job(jobName) {
    parameters {
      stringParam('URL', '', 'Repository URL')
    }

    steps {
      shell('echo "${URL}"')
    }

  }
}

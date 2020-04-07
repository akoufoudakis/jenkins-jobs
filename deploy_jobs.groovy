def repoList = ['lienzo-core',
                'lienzo-tests',
                'droolsjbpm-build-bootstrap',
                'kie-soup',
                'appformer',
                'droolsjbpm-knowledge',
                'drools']

for(repo in repoList) {
  def jobName = 'srcclr-scan-' + "${repo}"
  job(jobName) {
    parameters {
      stringParam('URL', '', 'Repository URL')
    }

    steps {
      shell('echo "${URL}"')
    }

  }
}

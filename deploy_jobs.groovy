
job("srcclr-scan") {
    parameters {
      stringParam('URL', '', 'Repository URL')
    }

    steps {
      shell('echo "${URL}"')
    }
}

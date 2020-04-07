def repoList = []

configFileProvider([configFile(fileId: '9018a8b6-f91d-4da6-9007-03f68830e118', variable:'repoListFile')]) {
  def repoFile = readFile "$repoListFile"
  def repoList = repoFile.readLines()

}

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

job("Created Job") {
  parameters {
    stringParam('URL')
  }

  steps {
    shell('echo ${URL}')
  }

}

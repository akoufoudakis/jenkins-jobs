job("Seed Job") {
  parameters{
    stringParam('URL', '')
  }

  steps {
    shell('echo ${URL}')
  }

}

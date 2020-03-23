job("Seed Job") {
  parameters{
    stringParam('URL', '')
  }

  String params = ${URL}

  steps {
    shell('echo ${params}')
  }

}

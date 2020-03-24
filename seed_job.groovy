job("Created Job") {
  parameters {
    stringParam('URL')
  }

  String param = '$URL'

  steps {
    shell('echo $param')
  }

}

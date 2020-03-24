job("Created Job") {
  parameters {
    stringParam('URL')
  }

  environmentVariables {
    groovy(
      '''
        String $param = '$URL'.trim()
      '''
    )
  }

  steps {
    shell('echo $param')
  }

}

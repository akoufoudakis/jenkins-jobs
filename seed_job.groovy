job("Created Job") {
  parameters {
    stringParam('URL')
  }

  environmentVariables {
    groovy(
      '''
          String param = '$URL'.trim()
          return [PARAM: param]
      '''
    )
  }

  steps {
    shell('echo $PARAM')
  }

}

job("Created Job") {
  parameters {
    stringParam('URL')
  }

  environmentVariables {
    groovy(
      '''
          String param = '$URL'
          return [PARAM: param]
      '''
    )
  }

  steps {
    shell('echo $PARAM')
  }

}

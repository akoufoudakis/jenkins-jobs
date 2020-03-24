job("Created Job") {
  parameters {
    stringParam('URL')
  }

  environmentVariables {
    groovy(
       def map = [:]
       String param = '$URL'
       map.put("PARAM", param)
       return map
    )
  }

  steps {
    shell('echo $PARAM')
  }

}

//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent } from 'react-native'

const Test = requireNativeComponent('Test', null)

class TestView extends Component {
  render () {
    return <Test {...this.props} />
  }
}

TestView.propTypes = {
  exampleProp: React.PropTypes.any
}

export default TestView

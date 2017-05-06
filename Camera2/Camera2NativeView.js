//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent } from 'react-native'

const Camera2 = requireNativeComponent('Camera2', null)

class Camera2View extends Component {
  render () {
    return <Camera2 {...this.props} />
  }
}

Camera2View.propTypes = {
  exampleProp: React.PropTypes.any
}

export default Camera2View



/*import { PropTypes } from 'react';  
import { requireNativeComponent, View } from 'react-native';

var iface = {  
    name: 'Camera2View',
    PropTypes: {
          exampleProp: PropTypes.string,
          ...View.propTypes // include the default view properties
    }
}

module.exports = requireNativeComponent('Camera2', iface); */

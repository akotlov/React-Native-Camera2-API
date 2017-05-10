//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent } from 'react-native'

const VideoRecorder = requireNativeComponent('VideoRecorder', null)

class VideoRecorderView extends Component {
  render () {
    return <VideoRecorder {...this.props} />
  }
}

VideoRecorderView.propTypes = {
  exampleProp: React.PropTypes.any
}

export default VideoRecorderView



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

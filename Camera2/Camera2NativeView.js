//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent } from 'react-native'

const Camera2 = requireNativeComponent('Camera2', Camera2View, {nativeOnly: {onRecordingFinished: true}})

export default class Camera2View extends Component {
  constructor(props) {
    super(props);
    console.log("Camera2View props: ", props)
    this._onFinish = this._onFinish.bind(this);
  }
  _onFinish(event) {
    if (!this.props.onFinish) {
      return;
    }
    this.props.onFinish(event.nativeEvent.file);
  }
  render () {
    return <Camera2 {...this.props} onRecordingFinished={this._onFinish} />
  }
}

Camera2View.propTypes = {
  //onRecordingFinish: React.PropTypes.func,
  onFinish: React.PropTypes.func,
  exampleProp: React.PropTypes.any
}
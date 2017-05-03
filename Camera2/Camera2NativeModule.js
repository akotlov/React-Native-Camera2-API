//  Created by react-native-create-bridge

import { NativeModules } from 'react-native'

const { Camera2 } = NativeModules

export default {
  exampleMethod () {
    return Camera2.exampleMethod()
  },

  EXAMPLE_CONSTANT: Camera2.EXAMPLE_CONSTANT
}

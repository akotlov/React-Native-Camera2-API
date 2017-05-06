/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Button,
  TouchableOpacity,
  ViewPagerAndroid
} from 'react-native';

import  { ViewPagerScrollState } from 'ViewPagerAndroid';

import Camera2View from './Camera2/Camera2NativeView'
import TestView from './Test/TestNativeView'

export default class NativeView extends Component {
  render() {
    return (
      <View style={styles.container}>
          <Button onPress={() => {}} title='Button' style={{flex: 1}} />
          <TestView style={{flex: 1}}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  preview: {
    flex: 1,
    justifyContent: 'flex-end',
    alignItems: 'center',
    //height: Dimensions.get('window').height,
    //width: Dimensions.get('window').width
  },
  overlay: {
    position: 'absolute',
    padding: 10,
    right: 0,
    left: 0,
    alignItems: 'center',
  },
  topOverlay: {
    top: 0,
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
   containerOne: {
    //flex: 1,
    //backgroundColor: 'grey',
  },
  containerTwo: {
    //flex: 1,
    //backgroundColor: 'green',
  },
  viewPager: {
    flex: 1,
  }
});

AppRegistry.registerComponent('NativeView', () => NativeView);


/*
        <Camera2View style={styles.preview}/>
*/



/*

<ViewPagerAndroid
          style={styles.viewPager}
          initialPage={2}
          pageMargin={0}
          keyboardDismissMode={'on-drag'}
          ref={viewPager => { this.viewPager = viewPager; }}>
      
       <View style={styles.containerOne}>
         <TouchableOpacity style={styles.topButton}>
                    <Button onPress={() => {}} title='One' style={{}} />
            </TouchableOpacity>
         </View>

          <View style={styles.containerTwo}>
          <TouchableOpacity style={styles.topButton}>
                    <Button onPress={() => {}} title='Two' style={{}} />
            </TouchableOpacity>
            </View>
            <View style={styles.containerTwo}>
             <TestView />
            </View>
      </ViewPagerAndroid>

      */


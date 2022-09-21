import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, Switch, SafeAreaView, TextInput, TouchableWithoutFeedback, TouchableOpacity, StyleSheet, Animated, Dimensions, Vibration, Alert, KeyboardAvoidingView, Platform} from "react-native";
import { Svg, Path } from "react-native-svg";
import CheckBox from "react-native-check-box";
import { WebView } from "react-native-webview";
import { HtmlText } from "@e-mine/react-native-html-text";
import BottomSheet from "@gorhom/bottom-sheet";
import { useAuth } from "../../entities/auth";
import Icon from "react-native-vector-icons/Entypo";
import { getTable } from "../../shared/api/data";
export const Page_styleBumpPlanScreen = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleMenuSearchPanel}>
						<Image style = {stylesheet.styleIcons8Search1201} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/d24DDaGxz7DxMwNg7qBt4ryZ.png"}}/>
						<Image style = {stylesheet.styleIcons8Menu1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/etzGcPqAcrYLCLHXU0FlG7OF.png"}}/>
						<Text style = {stylesheet.styleDacoApp}>
							DACO APP
						</Text>
					</View>
					<View style = {stylesheet.styleTopGroup}>
						<Image style = {stylesheet.styleBatteryIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/xoarnNa4QQpCos8ZhNVus4XV.png"}}/>
						<Image style = {stylesheet.styleSignalIcon1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/yZrebCIVE59d3c1uzv2tVVqR.png"}}/>
						<Text style = {stylesheet.style1100}>
							11:00
						</Text>
					</View>
					<View style = {stylesheet.styleContinueButton}>
						<View style = {stylesheet.styleLoginbox}>
						</View>
						<Text style = {stylesheet.styleContinue}>
							Continue
						</Text>
					</View>
					<View style = {stylesheet.styleDisplacedContentPanel}>
						<View style = {stylesheet.styleRectangle4}>
						</View>
						<Text style = {stylesheet.styleRedistributedPersonnelAndCargo}>
							Redistributed Personnel and Cargo
						</Text>
						<View style = {stylesheet.styleTextField}>
							<View style = {stylesheet.styleRectangle14}>
							</View>
							<View style = {stylesheet.styleBobBobby}>
								<View style = {stylesheet.styleIcons8People6412}>
									<Image style = {stylesheet.styleIcons8People641} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/2aY1w8oXdMZgen5p0gYK2pQ1.png"}}/>
								</View>
								<View style = {stylesheet.stylePlaneListing}>
									<Text style = {stylesheet.stylePlane1}>
										Bob Bobby
									</Text>
								</View>
							</View>
							<View style = {stylesheet.styleJohnDoe}>
								<View style = {stylesheet.stylePlaneListingCopy1}>
									<Text style = {stylesheet.stylePlane1Copy1}>
										John Doe
									</Text>
								</View>
								<View style = {stylesheet.styleIcons8People6412Copy1}>
									<Image style = {stylesheet.styleIcons8People641Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/aulezbaX4CsGYdGZ7TkI8bWb.png"}}/>
								</View>
							</View>
							<View style = {stylesheet.styleLoad1}>
								<View style = {stylesheet.stylePlaneListingCopy2}>
									<Text style = {stylesheet.stylePlane1Copy2}>
										Load 1
									</Text>
								</View>
								<Image style = {stylesheet.styleIcons8Cargo6411} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/3J3h73hL9lR1I2Iz4U6Fgqnd.png"}}/>
							</View>
							<View style = {stylesheet.styleLine22}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
							<View style = {stylesheet.styleLine23}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1001}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/5opJg5GUXJMbh8NY78LNpedb.png"}}/>
						</View>
					</View>
					<Image style = {stylesheet.styleIcons8FighterJet1001} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/8yh2rkmi2QLZXfaSVochVNuQ.png"}}/>
					<Image style = {stylesheet.styleIcons8FighterJet1002} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/DPRfJPm4MLogUaG1BQdIX0Js.png"}}/>
					<View style = {stylesheet.styleRemovedAircraftPanel}>
						<View style = {stylesheet.styleRectangle16}>
							<Svg
								fill = "rgba(227, 227, 227, 1)"
								stroke = "rgba(0, 0, 0, 1)"
							>
								<Path d="M0 5C0 2.23858 2.23858 0 5 0L409 0C411.761 0 414 2.23858 414 5L414 119C414 121.761 411.761 124 409 124L4.99999 124C2.23857 124 0 121.761 0 119L0 5Z"/>
							</Svg>
						</View>
						<Text style = {stylesheet.styleRemovedAircraft}>
							Removed Aircraft
						</Text>
						<View style = {stylesheet.styleRectangle17}>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy3}>
							<Text style = {stylesheet.stylePlane1Copy3}>
								Plane 6
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/JQTwqumy9pm0Ys3vI5iF0IMj.png"}}/>
							<Text style = {stylesheet.style_}>
								. . .
							</Text>
						</View>
					</View>
					<Text style = {stylesheet.stylePlane2}>
						Plane 2
					</Text>
					<Text style = {stylesheet.styleHelicopter3}>
						Helicopter 3
					</Text>
					<Text style = {stylesheet.stylePlane2Copy1}>
						Plane 2
					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleIcons8Search1201: {
		position: "absolute",
		left: 350,
		top: 7,
		borderRadius: null,
		width: 40,
		height: 40,
	},
	styleIcons8Menu1: {
		position: "absolute",
		left: 0,
		top: 7,
		borderRadius: null,
		width: 45,
		height: 35,
	},
	styleDacoApp: {
		position: "absolute",
		left: 31,
		top: 0,
		width: 321,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 40,
		fontFamily: "Arial_400Regular",
		letterSpacing: 1.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 46.9,
	},
	styleMenuSearchPanel: {
		position: "absolute",
		left: 14,
		top: 49,
		width: 390,
		height: 52,
	},
	styleBatteryIcon: {
		position: "absolute",
		left: 360,
		top: 2,
		borderRadius: null,
		width: 29,
		height: 18,
	},
	styleSignalIcon1: {
		position: "absolute",
		left: 327,
		top: 2,
		borderRadius: null,
		width: 28,
		height: 18,
	},
	style1100: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 53,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.4,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 21.1,
	},
	styleTopGroup: {
		position: "absolute",
		left: 12,
		top: 8,
		width: 389,
		height: 20,
	},
	styleLoginbox: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 149,
		height: 51,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(27, 136, 215, 1)",
	},
	styleContinue: {
		position: "absolute",
		left: 12,
		top: 0,
		width: 128,
		color: "rgba(255, 255, 255, 1)",
		fontSize: 28,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 32.8,
	},
	styleContinueButton: {
		position: "absolute",
		left: 252,
		top: 724,
		width: 149,
		height: 51,
	},
	styleRectangle4: {
		position: "absolute",
		left: 15,
		top: 0,
		width: 414,
		height: 466,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleRedistributedPersonnelAndCargo: {
		position: "absolute",
		left: 0,
		top: 5,
		width: 446,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.75,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 29.3,
	},
	styleRectangle14: {
		position: "absolute",
		left: 1,
		top: 0,
		width: 395,
		height: 403,
		borderRadius: 5,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 1)",
	},
	styleIcons8People641: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	stylePlane1: {
		position: "absolute",
		left: 36,
		top: 6,
		width: 159,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	stylePlaneListing: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 392,
		height: 35,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleBobBobby: {
		position: "absolute",
		left: 0,
		top: 6,
		width: 392,
		height: 35,
	},
	stylePlane1Copy1: {
		position: "absolute",
		left: 34,
		top: 6,
		width: 152,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	stylePlaneListingCopy1: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 374,
		height: 35,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy1: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 22,
		height: 25,
	},
	styleIcons8People6412Copy1: {
		position: "absolute",
		left: 10,
		top: 3,
		width: 22,
		height: 25,
	},
	styleJohnDoe: {
		position: "absolute",
		left: 1,
		top: 47,
		width: 374,
		height: 35,
	},
	stylePlane1Copy2: {
		position: "absolute",
		left: 28,
		top: 6,
		width: 124,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	stylePlaneListingCopy2: {
		position: "absolute",
		left: 1,
		top: 0,
		width: 305,
		height: 35,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8Cargo6411: {
		position: "absolute",
		left: 0,
		top: 9,
		borderRadius: null,
		width: 21,
		height: 18,
	},
	styleLoad1: {
		position: "absolute",
		left: 9,
		top: 95,
		width: 306,
		height: 35,
	},
	styleLine22: {
		position: "absolute",
		left: 2,
		right: -392,
		top: 90,
		bottom: 90,
		width: "auto",
		height: "auto",
	},
	styleLine23: {
		position: "absolute",
		left: 2,
		right: -392,
		top: 136,
		bottom: 136,
		width: "auto",
		height: "auto",
	},
	styleTextField: {
		position: "absolute",
		left: 24,
		top: 47,
		width: 396,
		height: 403,
	},
	styleIcons8Helicopter1001Copy1: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001: {
		position: "absolute",
		left: 200,
		top: 97,
		width: 31,
		height: 31,
	},
	styleDisplacedContentPanel: {
		position: "absolute",
		left: -15,
		top: 227,
		width: 444,
		height: 466,
	},
	styleIcons8FighterJet1001: {
		position: "absolute",
		left: 194,
		top: 286,
		borderRadius: null,
		width: 22,
		height: 21,
	},
	styleIcons8FighterJet1002: {
		position: "absolute",
		left: 193,
		top: 379,
		borderRadius: null,
		width: 22,
		height: 21,
	},
	styleRectangle16: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -124,
		width: "auto",
		height: "auto",
	},
	styleRemovedAircraft: {
		position: "absolute",
		left: 11,
		top: 4,
		width: 336,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.75,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 29.3,
	},
	styleRectangle17: {
		position: "absolute",
		left: 9,
		top: 41,
		width: 395,
		height: 76,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 252, 252, 1)",
	},
	stylePlane1Copy3: {
		position: "absolute",
		left: 36,
		top: 4,
		width: 159,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleIcons8FighterJet1001Copy1: {
		position: "absolute",
		left: 5,
		top: 4,
		borderRadius: null,
		width: 22,
		height: 21,
	},
	style_: {
		position: "absolute",
		left: 361,
		top: 0,
		width: 32,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	stylePlaneListingCopy3: {
		position: "absolute",
		left: 11,
		top: 43,
		width: 391,
		height: 27,
		borderRadius: 5,
		backgroundColor: "rgba(255, 4, 4, 1)",
	},
	styleRemovedAircraftPanel: {
		position: "absolute",
		left: 0,
		top: 103,
		width: 414,
		height: 124,
	},
	stylePlane2: {
		position: "absolute",
		left: 224,
		top: 286,
		width: 136,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleHelicopter3: {
		position: "absolute",
		left: 228,
		top: 326,
		width: 138,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	stylePlane2Copy1: {
		position: "absolute",
		left: 224,
		top: 378,
		width: 114,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});
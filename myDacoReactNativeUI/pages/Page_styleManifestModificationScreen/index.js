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
export const Page_styleManifestModificationScreen = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleTopBar}>
					</View>
					<View style = {stylesheet.stylePersonnelPanel}>
						<View style = {stylesheet.styleRectangle8}>
						</View>
						<View style = {stylesheet.styleGroup10}>
							<View style = {stylesheet.stylePlaneListing}>
								<Text style = {stylesheet.stylePlane1}>
									John Doe
								</Text>
								<Text style = {stylesheet.style_}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412}>
								<Image style = {stylesheet.styleIcons8People641} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/yANqBFY2PROADu1LWaDSaOl7.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup9}>
							<View style = {stylesheet.styleIcons8People6412Copy1}>
								<Image style = {stylesheet.styleIcons8People641Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/oSoPRsVs0lr52qpsoDW68XXj.png"}}/>
							</View>
							<View style = {stylesheet.stylePlaneListingCopy1}>
								<Text style = {stylesheet.stylePlane1Copy1}>
									Bob Bobby
								</Text>
								<Text style = {stylesheet.style_Copy1}>
									. . .
								</Text>
							</View>
						</View>
						<View style = {stylesheet.styleGroup8}>
							<View style = {stylesheet.stylePlaneListingCopy2}>
								<Text style = {stylesheet.stylePlane1Copy2}>
									James Mitchell
								</Text>
								<Text style = {stylesheet.style_Copy2}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy2}>
								<Image style = {stylesheet.styleIcons8People641Copy2} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/c6BslGKRJsDt3CUhCYilZYKn.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup7}>
							<View style = {stylesheet.stylePlaneListingCopy3}>
								<Text style = {stylesheet.stylePlane1Copy3}>
									Tim Preston
								</Text>
								<Text style = {stylesheet.style_Copy3}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy3}>
								<Image style = {stylesheet.styleIcons8People641Copy3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/YuHs6GouWoQVcOd4vQvzoyJt.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup6}>
							<View style = {stylesheet.stylePlaneListingCopy4}>
								<Text style = {stylesheet.stylePlane1Copy4}>
									Donald Williams
								</Text>
								<Text style = {stylesheet.style_Copy4}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy4}>
								<Image style = {stylesheet.styleIcons8People641Copy4} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/w6HVMTRyZA36EBcgc1BZNoZT.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup5}>
							<View style = {stylesheet.stylePlaneListingCopy5}>
								<Text style = {stylesheet.stylePlane1Copy5}>
									Chris Rogers
								</Text>
								<Text style = {stylesheet.style_Copy5}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy5}>
								<Image style = {stylesheet.styleIcons8People641Copy5} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/i8NDDAZQFWdSzrPIZgzeXI3H.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup4}>
							<View style = {stylesheet.stylePlaneListingCopy6}>
								<Text style = {stylesheet.stylePlane1Copy6}>
									John Jonson
								</Text>
								<Text style = {stylesheet.style_Copy6}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy6}>
								<Image style = {stylesheet.styleIcons8People641Copy6} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/A2Wj5p1qZZIDYrOrqYi7QwN0.png"}}/>
							</View>
						</View>
						<View style = {stylesheet.styleGroup3}>
							<View style = {stylesheet.stylePlaneListingCopy7}>
								<Text style = {stylesheet.stylePlane1Copy7}>
									Tyler Smith
								</Text>
								<Text style = {stylesheet.style_Copy7}>
									. . .
								</Text>
							</View>
							<View style = {stylesheet.styleIcons8People6412Copy7}>
								<Image style = {stylesheet.styleIcons8People641Copy7} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/iQR2TFAzhQrfioGKHRusaz8y.png"}}/>
							</View>
						</View>
						<Text style = {stylesheet.stylePersonnel}>
							Personnel
						</Text>
						<Image style = {stylesheet.styleIconsExpandArrow3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/kwmmmyZTbwIvcaTEZkHxppiR.png"}}/>
					</View>
					<View style = {stylesheet.styleCargoPanel}>
						<View style = {stylesheet.styleRectangle8Copy1}>
						</View>
						<Text style = {stylesheet.styleCargo}>
							Cargo
						</Text>
						<Image style = {stylesheet.styleIconsExpandArrow4} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/r0AfH251YxXjP499Ju1SDIx4.png"}}/>
					</View>
					<View style = {stylesheet.styleCargoPanelCopy1}>
						<View style = {stylesheet.styleRectangle8Copy2}>
						</View>
						<Text style = {stylesheet.styleCargoCopy1}>
							Cargo
						</Text>
						<Image style = {stylesheet.styleIconsExpandArrow4Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/9P6lrfGMFlHllo6tQR9VhKZJ.png"}}/>
					</View>
					<View style = {stylesheet.stylePlane1ManifestPanel}>
						<View style = {stylesheet.styleRectangle9}>
						</View>
						<Text style = {stylesheet.stylePlane1Manifest}>
							Plane 1 Manifest
						</Text>
					</View>
					<View style = {stylesheet.styleGoBackButton}>
						<Image style = {stylesheet.styleIconsBack1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/pLAE0EeKWC2i0Cgaux3GlOSR.png"}}/>
						<Text style = {stylesheet.styleGoBack}>
							Go Back 
						</Text>
					</View>
					<View style = {stylesheet.styleMenuSearchPanel}>
						<Image style = {stylesheet.styleIcons8Search1201} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/JNGRc1niyTeFwjjWGk77uhPz.png"}}/>
						<Text style = {stylesheet.styleDacoApp}>
							DACO APP
						</Text>
						<Image style = {stylesheet.styleIcons8Menu1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/otfajOmzFCD24hAP8ifKPwT0.png"}}/>
					</View>
					<View style = {stylesheet.styleTopGroup}>
						<Image style = {stylesheet.styleBatteryIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/nfYU28EOMAPGE3PiUIPREpUp.png"}}/>
						<Image style = {stylesheet.styleSignalIcon1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/c9u9LGCQ7zi5fZ0btQVIyvr7.png"}}/>
						<Text style = {stylesheet.style1100}>
							11:00
						</Text>
					</View>
					<View style = {stylesheet.styleGroup10Copy1}>
						<View style = {stylesheet.stylePlaneListingCopy8}>
							<Text style = {stylesheet.stylePlane1Copy8}>
								Load 1
							</Text>
							<Text style = {stylesheet.style_Copy8}>
								. . .
							</Text>
						</View>
					</View>
					<View style = {stylesheet.styleGroup11}>
						<View style = {stylesheet.stylePlaneListingCopy9}>
							<Text style = {stylesheet.stylePlane1Copy9}>
								Load 2
							</Text>
							<Text style = {stylesheet.style_Copy9}>
								. . .
							</Text>
						</View>
					</View>
					<Image style = {stylesheet.styleIcons8Cargo6411} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/mPjnKq9nWPbuSmkd4qzdce9X.png"}}/>
					<Image style = {stylesheet.styleIcons8Cargo6412} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/wgKO2BG6l9szL5sK5W9KmxVg.png"}}/>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleTopBar: {
		position: "absolute",
		left: 0,
		top: 101,
		width: 414,
		height: 629,
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleRectangle8: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 335,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	stylePlane1: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
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
	styleGroup10: {
		position: "absolute",
		left: 0,
		top: 296,
		width: 414,
		height: 35,
	},
	styleIcons8People641Copy1: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy1: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	stylePlane1Copy1: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy1: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleGroup9: {
		position: "absolute",
		left: 0,
		top: 261,
		width: 414,
		height: 35,
	},
	stylePlane1Copy2: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy2: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy2: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy2: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup8: {
		position: "absolute",
		left: 0,
		top: 226,
		width: 414,
		height: 35,
	},
	stylePlane1Copy3: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy3: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy3: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy3: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup7: {
		position: "absolute",
		left: 0,
		top: 191,
		width: 414,
		height: 35,
	},
	stylePlane1Copy4: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy4: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy4: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy4: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy4: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup6: {
		position: "absolute",
		left: 0,
		top: 156,
		width: 414,
		height: 35,
	},
	stylePlane1Copy5: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy5: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy5: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy5: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy5: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup5: {
		position: "absolute",
		left: 0,
		top: 121,
		width: 414,
		height: 35,
	},
	stylePlane1Copy6: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy6: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy6: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy6: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy6: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup4: {
		position: "absolute",
		left: 0,
		top: 86,
		width: 414,
		height: 35,
	},
	stylePlane1Copy7: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy7: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy7: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleIcons8People641Copy7: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 25,
	},
	styleIcons8People6412Copy7: {
		position: "absolute",
		left: 11,
		top: 3,
		width: 24,
		height: 25,
	},
	styleGroup3: {
		position: "absolute",
		left: 0,
		top: 51,
		width: 414,
		height: 35,
	},
	stylePersonnel: {
		position: "absolute",
		left: 14,
		top: 9,
		width: 253,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 29.3,
	},
	styleIconsExpandArrow3: {
		position: "absolute",
		left: 382,
		top: 9,
		borderRadius: null,
		width: 30,
		height: 30,
	},
	stylePersonnelPanel: {
		position: "absolute",
		left: 0,
		top: 152,
		width: 414,
		height: 335,
	},
	styleRectangle8Copy1: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 243,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleCargo: {
		position: "absolute",
		left: 14,
		top: 3,
		width: 253,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 29.3,
	},
	styleIconsExpandArrow4: {
		position: "absolute",
		left: 382,
		top: 7,
		borderRadius: null,
		width: 30,
		height: 24,
	},
	styleCargoPanel: {
		position: "absolute",
		left: 0,
		top: 487,
		width: 414,
		height: 243,
	},
	styleRectangle8Copy2: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 243,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleCargoCopy1: {
		position: "absolute",
		left: 14,
		top: 3,
		width: 253,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 29.3,
	},
	styleIconsExpandArrow4Copy1: {
		position: "absolute",
		left: 382,
		top: 7,
		borderRadius: null,
		width: 30,
		height: 24,
	},
	styleCargoPanelCopy1: {
		position: "absolute",
		left: 0,
		top: 487,
		width: 414,
		height: 243,
	},
	styleRectangle9: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 51,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	stylePlane1Manifest: {
		position: "absolute",
		left: 11,
		top: 12,
		width: 253,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 29.3,
	},
	stylePlane1ManifestPanel: {
		position: "absolute",
		left: 0,
		top: 101,
		width: 414,
		height: 57,
	},
	styleIconsBack1: {
		position: "absolute",
		left: 0,
		top: 0,
		borderRadius: null,
		width: 40,
		height: 40,
	},
	styleGoBack: {
		position: "absolute",
		left: 34,
		top: 5,
		width: 94,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 29.3,
	},
	styleGoBackButton: {
		position: "absolute",
		left: 3,
		top: 740,
		width: 126,
		height: 40,
	},
	styleIcons8Search1201: {
		position: "absolute",
		left: 350,
		top: 7,
		borderRadius: null,
		width: 40,
		height: 40,
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
	styleIcons8Menu1: {
		position: "absolute",
		left: 0,
		top: 7,
		borderRadius: null,
		width: 45,
		height: 35,
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
	stylePlane1Copy8: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy8: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy8: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleGroup10Copy1: {
		position: "absolute",
		left: 0,
		top: 529,
		width: 414,
		height: 35,
	},
	stylePlane1Copy9: {
		position: "absolute",
		left: 38,
		top: 6,
		width: 168,
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
	style_Copy9: {
		position: "absolute",
		left: 382,
		top: 0,
		width: 34,
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
	stylePlaneListingCopy9: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 35,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(255, 255, 255, 0)",
	},
	styleGroup11: {
		position: "absolute",
		left: 0,
		top: 564,
		width: 414,
		height: 35,
	},
	styleIcons8Cargo6411: {
		position: "absolute",
		left: 8,
		top: 538,
		borderRadius: null,
		width: 21,
		height: 18,
	},
	styleIcons8Cargo6412: {
		position: "absolute",
		left: 8,
		top: 573,
		borderRadius: null,
		width: 21,
		height: 18,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});
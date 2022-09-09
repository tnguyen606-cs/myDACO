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
export const Page_styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2 = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleTopGroup}>
						<Image style = {stylesheet.styleBatteryIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/QlQOA2ZdNxwtqW8GRTX0QpkX.png"}}/>
						<Image style = {stylesheet.styleSignalIcon1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/LMhWAB5d0G0I3hFGPq3UM86v.png"}}/>
						<Text style = {stylesheet.style1100}>
							11:00
						</Text>
					</View>
					<View style = {stylesheet.styleGoBackButton}>
						<Image style = {stylesheet.styleIconsBack1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/99iqyWCBCOImWYzLJKZqiSwE.png"}}/>
						<Text style = {stylesheet.styleGoBack}>
							Go Back 
						</Text>
					</View>
					<Text style = {stylesheet.styleSearchManifest}>
						Search Manifest
					</Text>
					<View style = {stylesheet.styleSearchHistory}>
						<View style = {stylesheet.styleRectangle2}>
						</View>
						<Text style = {stylesheet.styleRecentHistory}>
							Recent History
						</Text>
						<Text style = {stylesheet.styleJake}>
							jake
						</Text>
						<Text style = {stylesheet.styleB2Condor}>
							B-2 Condor   
						</Text>
						<Text style = {stylesheet.styleAmy}>
							amy
						</Text>
						<Text style = {stylesheet.styleAmyy}>
							Amyy 
						</Text>
						<Text style = {stylesheet.styleCondor}>
							Condor
						</Text>
						<Text style = {stylesheet.styleEurope}>
							europe 
						</Text>
						<Text style = {stylesheet.styleLockheedC5}>
							Lockheed C-5 
						</Text>
						<Text style = {stylesheet.styleArtillery}>
							artillery 
						</Text>
					</View>
					<View style = {stylesheet.styleSearchBox}>
						<View style = {stylesheet.styleRectangle1}>
						</View>
						<Text style = {stylesheet.styleJ}>
							J
						</Text>
						<View style = {stylesheet.styleIcons8Search1}>
							<View style = {stylesheet.styleVector}>
								<Svg
									fill = "rgba(0, 0, 0, 1)"
								>
									<Path d="M7 0C3.14585 0 0 2.81187 0 6.25685C0 9.70183 3.14585 12.5137 7 12.5137C8.748 12.5137 10.345 11.9309 11.5742 10.9774L12 11.358L12 12.5137L18 17.8767L20 16.089L14 10.726L12.707 10.726L12.2812 10.3454C13.348 9.24674 14 7.81927 14 6.25685C14 2.81187 10.8541 0 7 0ZM7 1.78767C9.77327 1.78767 12 3.778 12 6.25685C12 8.7357 9.77327 10.726 7 10.726C4.22673 10.726 2 8.7357 2 6.25685C2 3.778 4.22673 1.78767 7 1.78767Z"/>
								</Svg>
							</View>
						</View>
					</View>
					<Text style = {stylesheet.styleTrySearchingForPeopleOrKeywords}>
						Try searching for people or keywords

					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
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
	styleSearchManifest: {
		position: "absolute",
		left: 63,
		top: 28,
		width: 300,
		color: "rgba(26, 135, 214, 1)",
		fontSize: 48,
		fontFamily: "Arial_400Regular",
		letterSpacing: 1.9000000000000004,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 56.3,
	},
	styleRectangle2: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 298,
		height: 331,
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleRecentHistory: {
		position: "absolute",
		left: 37,
		top: 15,
		width: 102,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleJake: {
		position: "absolute",
		left: 38,
		top: 41,
		width: 30,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 16.4,
	},
	styleB2Condor: {
		position: "absolute",
		left: 37,
		top: 65,
		width: 78,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 16.4,
	},
	styleAmy: {
		position: "absolute",
		left: 38,
		top: 88,
		width: 30,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleAmyy: {
		position: "absolute",
		left: 38,
		top: 112,
		width: 39,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleCondor: {
		position: "absolute",
		left: 37,
		top: 136,
		width: 51,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleEurope: {
		position: "absolute",
		left: 37,
		top: 160,
		width: 50,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleLockheedC5: {
		position: "absolute",
		left: 37,
		top: 183,
		width: 93,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleArtillery: {
		position: "absolute",
		left: 37,
		top: 207,
		width: 59,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleSearchHistory: {
		position: "absolute",
		left: 64,
		top: 384,
		width: 298,
		height: 331,
	},
	styleRectangle1: {
		position: "absolute",
		left: 40,
		top: 0,
		width: 298,
		height: 54,
		borderRadius: 40,
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleJ: {
		position: "absolute",
		left: 0,
		top: 17,
		width: 379,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleVector: {
		position: "absolute",
		left: 2,
		right: -18,
		top: 1,
		bottom: -17,
		width: "auto",
		height: "auto",
	},
	styleIcons8Search1: {
		position: "absolute",
		left: 57,
		top: 13,
		width: 24,
		height: 21,
	},
	styleSearchBox: {
		position: "absolute",
		left: 24,
		top: 182,
		width: 377,
		height: 54,
	},
	styleTrySearchingForPeopleOrKeywords: {
		position: "absolute",
		left: 83,
		top: 163,
		width: 257,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});
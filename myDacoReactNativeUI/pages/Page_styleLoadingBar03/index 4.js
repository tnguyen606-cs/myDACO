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
export const Page_styleLoadingBar03 = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(28, 137, 216, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleRectangle2}>
					</View>
					<View style = {stylesheet.styleRectangle3}>
						<Svg
							fill = "rgba(74, 102, 246, 1)"
						>
							<Path d="M0 8C0 3.58172 3.58172 0 8 0L280 0C284.418 0 288 3.58172 288 8L288 88C288 92.4183 284.418 96 280 96L8 96C3.58173 96 0 92.4183 0 88L0 8Z"/>
						</Svg>
					</View>
					<View style = {stylesheet.styleLoadingBar}>
						<View style = {stylesheet.styleRectangle4}>
							<Svg
								fill = "rgba(170, 182, 246, 1)"
							>
								<Path d="M0 8C0 3.58172 3.58172 0 8 0L16 0C20.4183 0 24 3.58172 24 8L24 88C24 92.4183 20.4183 96 16 96L8 96C3.58172 96 0 92.4183 0 88L0 8Z"/>
							</Svg>
						</View>
						<View style = {stylesheet.styleRectangle5}>
							<Svg
								fill = "rgba(170, 182, 246, 1)"
							>
								<Path d="M0 8C0 3.58172 3.58172 0 8 0L280 0C284.418 0 288 3.58172 288 8L288 88C288 92.4183 284.418 96 280 96L8 96C3.58173 96 0 92.4183 0 88L0 8Z"/>
							</Svg>
						</View>
						<View style = {stylesheet.styleGroup2}>
							<View style = {stylesheet.styleRectangle5Copy1}>
								<Svg
									fill = "rgba(170, 182, 246, 1)"
								>
									<Path d="M0 8C0 3.58172 3.58172 0 8 0L280 0C284.418 0 288 3.58172 288 8L288 88C288 92.4183 284.418 96 280 96L8 96C3.58173 96 0 92.4183 0 88L0 8Z"/>
								</Svg>
							</View>
							<View style = {stylesheet.styleGroup1}>
								<View style = {stylesheet.styleVector1}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector6}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector7}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector8}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector9}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector10}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector2}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector3}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector4}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector5}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector11}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector12}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector13}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector14}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector15}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector16}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector17}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector18}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector19}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
								<View style = {stylesheet.styleVector20}>
									<Svg
										stroke = "rgba(27, 136, 215, 1)"
									>
										<Path d=""/>
									</Svg>
								</View>
							</View>
						</View>
					</View>
					<View style = {stylesheet.styleOverlay}>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleRectangle2: {
		position: "absolute",
		left: 56,
		top: 168,
		width: 320,
		height: 128,
		borderRadius: 16,
		backgroundColor: "rgba(39, 7, 133, 1)",
	},
	styleRectangle3: {
		position: "absolute",
		left: 72,
		right: -216,
		top: 184,
		bottom: 88,
		width: "auto",
		height: "auto",
	},
	styleRectangle4: {
		position: "absolute",
		left: 0,
		right: -24,
		top: 0,
		bottom: -96,
		width: "auto",
		height: "auto",
	},
	styleRectangle5: {
		position: "absolute",
		left: 0,
		right: -288,
		top: 0,
		bottom: -96,
		width: "auto",
		height: "auto",
	},
	styleRectangle5Copy1: {
		position: "absolute",
		left: 0,
		right: -288,
		top: 0,
		bottom: -96,
		width: "auto",
		height: "auto",
	},
	styleVector1: {
		position: "absolute",
		left: 152,
		right: 15,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector6: {
		position: "absolute",
		left: 192,
		right: 55,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector7: {
		position: "absolute",
		left: 232,
		right: 95,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector8: {
		position: "absolute",
		left: 272,
		right: 135,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector9: {
		position: "absolute",
		left: 312,
		right: 175,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector10: {
		position: "absolute",
		left: 352,
		right: 215,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector2: {
		position: "absolute",
		left: 114,
		right: -23,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector3: {
		position: "absolute",
		left: 76,
		right: -61,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector4: {
		position: "absolute",
		left: 38,
		right: -99,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector5: {
		position: "absolute",
		left: 0,
		right: -137,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector11: {
		position: "absolute",
		left: 544,
		right: 407,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector12: {
		position: "absolute",
		left: 584,
		right: 447,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector13: {
		position: "absolute",
		left: 624,
		right: 487,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector14: {
		position: "absolute",
		left: 664,
		right: 527,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector15: {
		position: "absolute",
		left: 704,
		right: 567,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector16: {
		position: "absolute",
		left: 744,
		right: 607,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector17: {
		position: "absolute",
		left: 506,
		right: 369,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector18: {
		position: "absolute",
		left: 468,
		right: 331,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector19: {
		position: "absolute",
		left: 430,
		right: 293,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleVector20: {
		position: "absolute",
		left: 392,
		right: 255,
		top: 0,
		bottom: -145,
		width: "auto",
		height: "auto",
	},
	styleGroup1: {
		position: "absolute",
		left: -104,
		top: -24,
		width: 881,
		height: 145,
	},
	styleGroup2: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 288,
		height: 96,
	},
	styleLoadingBar: {
		position: "absolute",
		left: 72,
		top: 184,
		width: 24,
		height: 96,
	},
	styleOverlay: {
		position: "absolute",
		left: 56,
		top: 168,
		width: 320,
		height: 128,
		borderRadius: 16,
		backgroundColor: "rgba(27, 136, 215, 1)",
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(28, 137, 216, 1)",
	},

});
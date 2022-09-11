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
export const Page_styleMainMenuScreenBeforeBump_ = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	const onClickstyleSelectedPlane = (value) => {
		navigation.navigate("styleInoperablePlaneUi");
	}
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleTopBar}>
					</View>
					<View style = {stylesheet.styleBumpButton}>
						<View style = {stylesheet.styleRectangle7}>
						</View>
						<Text style = {stylesheet.styleBump}>
							BUMP
						</Text>
					</View>
					<View style = {stylesheet.styleAirfieldAPanel}>
						<View style = {stylesheet.styleRectangle4}>
						</View>
						<View style = {stylesheet.styleLine4}>
							<Svg
								stroke = "rgba(0, 0, 0, 1)"
							>
								<Path d=""/>
							</Svg>
						</View>
						<View style = {stylesheet.styleLine5}>
							<View style = {stylesheet.styleLine5Copy1}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine6}>
							<View style = {stylesheet.styleLine5Copy2}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine7}>
							<View style = {stylesheet.styleLine5Copy3}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine8}>
							<View style = {stylesheet.styleLine5Copy4}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine9}>
							<View style = {stylesheet.styleLine5Copy5}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine10}>
							<View style = {stylesheet.styleLine5Copy6}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine11}>
							<View style = {stylesheet.styleLine5Copy7}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine12}>
							<View style = {stylesheet.styleLine5Copy8}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine13}>
							<View style = {stylesheet.styleLine5Copy9}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine14}>
							<View style = {stylesheet.styleLine5Copy10}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine15}>
							<View style = {stylesheet.styleLine5Copy11}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<Text style = {stylesheet.styleAirfieldManifest}>
							Airfield manifest
						</Text>
						<View style = {stylesheet.stylePlaneListing}>
							<Text style = {stylesheet.stylePlane1}>
								Plane 1
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/8TuSDfaXnyw91Naz4rvfWnZk.png"}}/>
							<Text style = {stylesheet.style_}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy1}>
							<Text style = {stylesheet.stylePlane1Copy1}>
								Plane 2
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/nrqjsQnzHyzDzuNCENmmfXDG.png"}}/>
							<Text style = {stylesheet.style_Copy1}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy2}>
							<Text style = {stylesheet.stylePlane1Copy2}>
								Plane 3
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001Copy2} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/IumQHU3DSSHrTJhXEjLmB5m9.png"}}/>
							<Text style = {stylesheet.style_Copy2}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy3}>
							<Text style = {stylesheet.stylePlane1Copy3}>
								Plane 4
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001Copy3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/OCofoXNCidkWD2kQLRCCyx2B.png"}}/>
							<Text style = {stylesheet.style_Copy3}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy4}>
							<Text style = {stylesheet.stylePlane1Copy4}>
								Plane 5
							</Text>
							<Image style = {stylesheet.styleIcons8FighterJet1001Copy4} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/IisvnaKlgltp4XJTclfRIb4N.png"}}/>
							<Text style = {stylesheet.style_Copy4}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy5}>
							<Text style = {stylesheet.stylePlane1Copy5}>
								Helicopter 1
							</Text>
							<Text style = {stylesheet.style_Copy5}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy6}>
							<Text style = {stylesheet.stylePlane1Copy6}>
								Helicopter 2
							</Text>
							<Text style = {stylesheet.style_Copy6}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy7}>
							<Text style = {stylesheet.stylePlane1Copy7}>
								Helicopter 3
							</Text>
							<Text style = {stylesheet.style_Copy7}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy8}>
							<Text style = {stylesheet.stylePlane1Copy8}>
								Helicopter 4
							</Text>
							<Text style = {stylesheet.style_Copy8}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy9}>
							<Text style = {stylesheet.stylePlane1Copy9}>
								Helicopter 5
							</Text>
							<Text style = {stylesheet.style_Copy9}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.stylePlaneListingCopy10}>
							<Text style = {stylesheet.stylePlane1Copy10}>
								Helicopter 6
							</Text>
							<Text style = {stylesheet.style_Copy10}>
								. . .
							</Text>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1001}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/VAPz7t2tFH1vVktk2YDcy3bs.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1002}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy2} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/MgIwP8NKBqD00CYgGhiyp9Jx.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1003}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/zAW5Me21smFwXQDplGYeiFQu.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1004}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy4} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/KbZvpR7NlzvZMRr7y98Zwdvh.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1005}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy5} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/zIGeJoXXGr1XUMl84aPgspiY.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8Helicopter1006}>
							<Image style = {stylesheet.styleIcons8Helicopter1001Copy6} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/VabkwJwjeBALfZmrFlB1Agfv.png"}}/>
						</View>
						<Image style = {stylesheet.styleIconsExpandArrow1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/Qo0k6Pm3HttwL4iYuz9E8ekm.png"}}/>
					</View>
					<View style = {stylesheet.stylePersonnelPanel}>
						<View style = {stylesheet.styleRectangle4Copy1}>
						</View>
						<View style = {stylesheet.styleIcons8People6411}>
							<Image style = {stylesheet.styleIcons8People641} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/P9P6EHARaiHLL42wgnpJe3tG.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8People6410}>
							<Image style = {stylesheet.styleIcons8People641Copy1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/9OziqwBvPS7zvKOacX3m0dd5.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8People648}>
							<Image style = {stylesheet.styleIcons8People641Copy2} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/8xc0mAazZNalEJ64suaRFt65.png"}}/>
						</View>
						<View style = {stylesheet.styleIcons8People649}>
							<Image style = {stylesheet.styleIcons8People641Copy3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/OeMwe8Z55hiYWJuK5lZr6bbK.png"}}/>
						</View>
						<View style = {stylesheet.styleLine6Copy1}>
							<View style = {stylesheet.styleLine5Copy12}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine7Copy1}>
							<View style = {stylesheet.styleLine5Copy13}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine8Copy1}>
							<View style = {stylesheet.styleLine5Copy14}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<View style = {stylesheet.styleLine9Copy1}>
							<View style = {stylesheet.styleLine5Copy15}>
								<Svg
									stroke = "rgba(0, 0, 0, 1)"
								>
									<Path d=""/>
								</Svg>
							</View>
						</View>
						<Text style = {stylesheet.styleJohnDoe}>
							John Doe
						</Text>
						<Text style = {stylesheet.styleWilliamRyan}>
							William Ryan
						</Text>
						<Text style = {stylesheet.styleJackDoe}>
							Jack Doe
						</Text>
						<Text style = {stylesheet.stylePatrickReynolds}>
							Patrick Reynolds
						</Text>
						<Text style = {stylesheet.stylePersonnelRoster}>
							Personnel Roster
						</Text>
						<Image style = {stylesheet.styleIconsExpandArrow2} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/FaMJomKwfIILsALNiAKohi9Y.png"}}/>
					</View>
					<View style = {stylesheet.styleMenuSearchPanel}>
						<Image style = {stylesheet.styleIcons8Menu1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/RDW4nHGNmmyN8bm978qHifdK.png"}}/>
						<Text style = {stylesheet.styleDacoApp}>
							DACO APP
						</Text>
					</View>
					<Image style = {stylesheet.styleIcons8Search1201} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/iHsW9slNABbeAeCrra08AbAq.png"}}/>
					<View style = {stylesheet.styleTopGroup}>
						<Image style = {stylesheet.styleBatteryIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/oyNhEHj8Ow11UdcUhPoAh2PC.png"}}/>
						<Image style = {stylesheet.styleSignalIcon1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/9YwGWuvQte19s1EgMmv06CQH.png"}}/>
						<Text style = {stylesheet.style1100}>
							11:00
						</Text>
					</View>
					<View style = {stylesheet.stylePlane6}>
						<Text style = {stylesheet.stylePlane6Copy1}>
							Plane 6

						</Text>
						<Image style = {stylesheet.styleIcons8FighterJet1001Copy5} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/XMaRiSBm09qjib1UV2IgFJD2.png"}}/>
					</View>
					<TouchableOpacity style = {stylesheet.styleSelectedPlane} onPress = {onClickstyleSelectedPlane} >
						<Text style = {stylesheet.style_Copy11}>
							. . .
						</Text>
					</TouchableOpacity>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleTopBar: {
		position: "absolute",
		left: 0,
		top: 106,
		width: 414,
		height: 680,
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleRectangle7: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 259,
		height: 60,
		borderRadius: 25,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(26, 135, 214, 1)",
	},
	styleBump: {
		position: "absolute",
		left: 63,
		top: 0,
		width: 136,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 50,
		fontFamily: "Arial_400Regular",
		letterSpacing: 2,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 58.6,
	},
	styleBumpButton: {
		position: "absolute",
		left: 79,
		top: 711,
		width: 259,
		height: 60,
	},
	styleRectangle4: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 414,
		height: 366,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleLine4: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 43,
		bottom: 42,
		width: "auto",
		height: "auto",
	},
	styleLine5Copy1: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine5: {
		position: "absolute",
		left: 0,
		top: 70,
		width: 414,
		height: 1,
	},
	styleLine5Copy2: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine6: {
		position: "absolute",
		left: 0,
		top: 97,
		width: 414,
		height: 1,
	},
	styleLine5Copy3: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine7: {
		position: "absolute",
		left: 0,
		top: 124,
		width: 414,
		height: 1,
	},
	styleLine5Copy4: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine8: {
		position: "absolute",
		left: 0,
		top: 150,
		width: 414,
		height: 1,
	},
	styleLine5Copy5: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine9: {
		position: "absolute",
		left: 0,
		top: 177,
		width: 414,
		height: 1,
	},
	styleLine5Copy6: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine10: {
		position: "absolute",
		left: 0,
		top: 204,
		width: 414,
		height: 1,
	},
	styleLine5Copy7: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine11: {
		position: "absolute",
		left: 0,
		top: 230,
		width: 414,
		height: 1,
	},
	styleLine5Copy8: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine12: {
		position: "absolute",
		left: 0,
		top: 257,
		width: 414,
		height: 1,
	},
	styleLine5Copy9: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine13: {
		position: "absolute",
		left: 0,
		top: 284,
		width: 414,
		height: 1,
	},
	styleLine5Copy10: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine14: {
		position: "absolute",
		left: 0,
		top: 311,
		width: 414,
		height: 1,
	},
	styleLine5Copy11: {
		position: "absolute",
		left: 0,
		right: -414,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine15: {
		position: "absolute",
		left: 0,
		top: 337,
		width: 414,
		height: 1,
	},
	styleAirfieldManifest: {
		position: "absolute",
		left: 8,
		top: 11,
		width: 217,
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
	stylePlane1: {
		position: "absolute",
		left: 37,
		top: 4,
		width: 163,
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
	styleIcons8FighterJet1001: {
		position: "absolute",
		left: 5,
		top: 4,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	style_: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 42,
		width: 402,
		height: 31,
	},
	stylePlane1Copy1: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
		top: 5,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	style_Copy1: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 68,
		width: 402,
		height: 31,
	},
	stylePlane1Copy2: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
	styleIcons8FighterJet1001Copy2: {
		position: "absolute",
		left: 5,
		top: 5,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	style_Copy2: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 95,
		width: 402,
		height: 31,
	},
	stylePlane1Copy3: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
	styleIcons8FighterJet1001Copy3: {
		position: "absolute",
		left: 5,
		top: 5,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	style_Copy3: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 122,
		width: 402,
		height: 31,
	},
	stylePlane1Copy4: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
	styleIcons8FighterJet1001Copy4: {
		position: "absolute",
		left: 5,
		top: 5,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	style_Copy4: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 148,
		width: 402,
		height: 31,
	},
	stylePlane1Copy5: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 202,
		width: 402,
		height: 31,
	},
	stylePlane1Copy6: {
		position: "absolute",
		left: 37,
		top: 4,
		width: 163,
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
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 229,
		width: 402,
		height: 31,
	},
	stylePlane1Copy7: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 255,
		width: 402,
		height: 31,
	},
	stylePlane1Copy8: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 282,
		width: 402,
		height: 31,
	},
	stylePlane1Copy9: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
		left: 371,
		top: 0,
		width: 33,
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
		left: 8,
		top: 309,
		width: 402,
		height: 31,
	},
	stylePlane1Copy10: {
		position: "absolute",
		left: 37,
		top: 5,
		width: 163,
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
	style_Copy10: {
		position: "absolute",
		left: 371,
		top: 0,
		width: 33,
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
	stylePlaneListingCopy10: {
		position: "absolute",
		left: 8,
		top: 335,
		width: 402,
		height: 31,
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
		left: 2,
		top: 204,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001Copy2: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1002: {
		position: "absolute",
		left: 2,
		top: 230,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001Copy3: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1003: {
		position: "absolute",
		left: 2,
		top: 257,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001Copy4: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1004: {
		position: "absolute",
		left: 2,
		top: 284,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001Copy5: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1005: {
		position: "absolute",
		left: 2,
		top: 311,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1001Copy6: {
		position: "absolute",
		left: 2,
		top: 0,
		borderRadius: null,
		width: 31,
		height: 31,
	},
	styleIcons8Helicopter1006: {
		position: "absolute",
		left: 2,
		top: 337,
		width: 31,
		height: 31,
	},
	styleIconsExpandArrow1: {
		position: "absolute",
		left: 378,
		top: 11,
		borderRadius: null,
		width: 30,
		height: 30,
	},
	styleAirfieldAPanel: {
		position: "absolute",
		left: 0,
		top: 106,
		width: 414,
		height: 368,
	},
	styleRectangle4Copy1: {
		position: "absolute",
		left: 1,
		top: 0,
		width: 413,
		height: 227,
		borderRadius: 5,
		borderWidth: 2,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(227, 227, 227, 1)",
	},
	styleIcons8People641: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 31,
	},
	styleIcons8People6411: {
		position: "absolute",
		left: 14,
		top: 189,
		width: 24,
		height: 31,
	},
	styleIcons8People641Copy1: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 31,
	},
	styleIcons8People6410: {
		position: "absolute",
		left: 14,
		top: 143,
		width: 24,
		height: 31,
	},
	styleIcons8People641Copy2: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 31,
	},
	styleIcons8People648: {
		position: "absolute",
		left: 14,
		top: 97,
		width: 24,
		height: 31,
	},
	styleIcons8People641Copy3: {
		position: "absolute",
		left: -3,
		top: 0,
		borderRadius: null,
		width: 24,
		height: 31,
	},
	styleIcons8People649: {
		position: "absolute",
		left: 14,
		top: 54,
		width: 24,
		height: 31,
	},
	styleLine5Copy12: {
		position: "absolute",
		left: 0,
		right: -413,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine6Copy1: {
		position: "absolute",
		left: 1,
		top: 48,
		width: 413,
		height: 1,
	},
	styleLine5Copy13: {
		position: "absolute",
		left: 0,
		right: -413,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine7Copy1: {
		position: "absolute",
		left: 0,
		top: 93,
		width: 413,
		height: 1,
	},
	styleLine5Copy14: {
		position: "absolute",
		left: 0,
		right: -413,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine8Copy1: {
		position: "absolute",
		left: 1,
		top: 137,
		width: 413,
		height: 1,
	},
	styleLine5Copy15: {
		position: "absolute",
		left: 0,
		right: -413,
		top: 0,
		bottom: -1,
		width: "auto",
		height: "auto",
	},
	styleLine9Copy1: {
		position: "absolute",
		left: 1,
		top: 182,
		width: 413,
		height: 1,
	},
	styleJohnDoe: {
		position: "absolute",
		left: 46,
		top: 58,
		width: 112,
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
	styleWilliamRyan: {
		position: "absolute",
		left: 46,
		top: 189,
		width: 141,
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
	styleJackDoe: {
		position: "absolute",
		left: 46,
		top: 101,
		width: 112,
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
	stylePatrickReynolds: {
		position: "absolute",
		left: 45,
		top: 146,
		width: 172,
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
	stylePersonnelRoster: {
		position: "absolute",
		left: 13,
		top: 7,
		width: 216,
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
	styleIconsExpandArrow2: {
		position: "absolute",
		left: 379,
		top: 7,
		borderRadius: null,
		width: 30,
		height: 37,
	},
	stylePersonnelPanel: {
		position: "absolute",
		left: -2,
		top: 474,
		width: 414,
		height: 227,
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
		width: 350,
		height: 52,
	},
	styleIcons8Search1201: {
		position: "absolute",
		left: 363,
		top: 55,
		borderRadius: null,
		width: 40,
		height: 40,
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
		left: 14,
		top: 8,
		width: 389,
		height: 20,
	},
	stylePlane6Copy1: {
		position: "absolute",
		left: 32,
		top: 0,
		width: 163,
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
	styleIcons8FighterJet1001Copy5: {
		position: "absolute",
		left: 0,
		top: 0,
		borderRadius: null,
		width: 23,
		height: 24,
	},
	stylePlane6: {
		position: "absolute",
		left: 13,
		top: 287,
		width: 193,
		height: 26,
	},
	style_Copy11: {
		position: "absolute",
		left: 378,
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
	styleSelectedPlane: {
		position: "absolute",
		left: -1,
		top: 283,
		width: 410,
		height: 29,
		backgroundColor: "rgba(229, 229, 229, 1)",
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});
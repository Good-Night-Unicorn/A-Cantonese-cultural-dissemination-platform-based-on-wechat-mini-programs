<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">歌名</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.songname" v-model="ruleForm.songname" placeholder="歌名"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">音乐分类</view>
				<picker :disabled="ro.yinlefenlei" :style='{"border":"2rpx solid #D9DADC","padding":"0 20rpx","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","width":"100%","height":"auto"}' @change="yinlefenleiChange" :value="yinlefenleiIndex" :range="yinlefenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#43B3BE"}' class="uni-input">{{ruleForm.yinlefenlei?ruleForm.yinlefenlei:"请选择音乐分类"}}</view>
				</picker>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">编曲</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.bianqu" v-model="ruleForm.bianqu" placeholder="编曲"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">填词</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.tianci" v-model="ruleForm.tianci" placeholder="填词"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class=" input" @tap="songfileTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">音乐文件</view>
				<view class="right-input" :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","lineHeight":"80rpx","fontSize":"28rpx"}'>
					{{ruleForm.songfile?ruleForm.songfile:'点击上传音乐文件'}}
				</view>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">歌手</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.singer" v-model="ruleForm.singer" placeholder="歌手"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">语言</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yuyan" v-model="ruleForm.yuyan" placeholder="语言"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">专辑</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhuanji" v-model="ruleForm.zhuanji" placeholder="专辑"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">时长</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shizhang" v-model.number="ruleForm.shizhang" placeholder="时长" type="digit"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">发行方</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.faxingfang" v-model="ruleForm.faxingfang" placeholder="发行方"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">版权方</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.banquanfang" v-model="ruleForm.banquanfang" placeholder="版权方"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">发行日期</view>
				<picker  :disabled="ro.faxingriqi" :style='{"border":"2rpx solid #D9DADC","padding":"0 20rpx","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","width":"100%","height":"auto"}' mode="date" :value="ruleForm.faxingriqi" @change="faxingriqiChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#43B3BE"}' class="uni-input">{{ruleForm.faxingriqi?ruleForm.faxingriqi:"请选择发行日期"}}</view>
				</picker>
			</view>
                    
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">歌词</view>
				<xia-editor ref="lyric" :style='{"minHeight":"300rpx","border":"2rpx solid #D9DADC","padding":"20rpx","borderRadius":"8rpx","background":"#F8F8F8","width":"calc(100% - 160rpx)","height":"auto"}' v-model="ruleForm.lyric" placeholder="歌词" @editorChange="lyricChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","alignItems":"center","flexDirection":"column","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"20rpx 0","color":"rgb(255, 255, 255)","borderRadius":"10rpx","background":"#43B3BE","width":"48%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				songname: '',
				yinlefenlei: '',
				bianqu: '',
				tianci: '',
				songfile: '',
				fengmian: '',
				singer: '',
				yuyan: '',
				zhuanji: '',
				shizhang: '',
				faxingfang: '',
				banquanfang: '',
				faxingriqi: '',
				lyric: '',
				discussnum: '',
				storeupnum: '',
				},
				yinlefenleiOptions: [],
				yinlefenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   songname : false,
				   yinlefenlei : false,
				   bianqu : false,
				   tianci : false,
				   songfile : false,
				   fengmian : false,
				   singer : false,
				   yuyan : false,
				   zhuanji : false,
				   shizhang : false,
				   faxingfang : false,
				   banquanfang : false,
				   faxingriqi : false,
				   lyric : false,
				   thumbsupnum : false,
				   crazilynum : false,
				   clicktime : false,
				   clicknum : false,
				   discussnum : false,
				   storeupnum : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.faxingriqi = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`yinlefenlei`,`yinlefenlei`,{});
			this.yinlefenleiOptions = res.data;
			this.yinlefenleiOptions.unshift("请选择音乐分类");

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`yinlexinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='songname'){
						this.ruleForm.songname = obj[o];
						this.ro.songname = true;
						continue;
					}
					if(o=='yinlefenlei'){
						this.ruleForm.yinlefenlei = obj[o];
						this.ro.yinlefenlei = true;
						continue;
					}
					if(o=='bianqu'){
						this.ruleForm.bianqu = obj[o];
						this.ro.bianqu = true;
						continue;
					}
					if(o=='tianci'){
						this.ruleForm.tianci = obj[o];
						this.ro.tianci = true;
						continue;
					}
					if(o=='songfile'){
						this.ruleForm.songfile = obj[o];
						this.ro.songfile = true;
						continue;
					}
					if(o=='fengmian'){
						this.ruleForm.fengmian = obj[o].split(",")[0];
						this.ro.fengmian = true;
						continue;
					}
					if(o=='singer'){
						this.ruleForm.singer = obj[o];
						this.ro.singer = true;
						continue;
					}
					if(o=='yuyan'){
						this.ruleForm.yuyan = obj[o];
						this.ro.yuyan = true;
						continue;
					}
					if(o=='zhuanji'){
						this.ruleForm.zhuanji = obj[o];
						this.ro.zhuanji = true;
						continue;
					}
					if(o=='shizhang'){
						this.ruleForm.shizhang = obj[o];
						this.ro.shizhang = true;
						continue;
					}
					if(o=='faxingfang'){
						this.ruleForm.faxingfang = obj[o];
						this.ro.faxingfang = true;
						continue;
					}
					if(o=='banquanfang'){
						this.ruleForm.banquanfang = obj[o];
						this.ro.banquanfang = true;
						continue;
					}
					if(o=='faxingriqi'){
						this.ruleForm.faxingriqi = obj[o];
						this.ro.faxingriqi = true;
						continue;
					}
					if(o=='lyric'){
						this.ruleForm.lyric = obj[o];
						this.ro.lyric = true;
						continue;
					}
					if(o=='thumbsupnum'){
						this.ruleForm.thumbsupnum = obj[o];
						this.ro.thumbsupnum = true;
						continue;
					}
					if(o=='crazilynum'){
						this.ruleForm.crazilynum = obj[o];
						this.ro.crazilynum = true;
						continue;
					}
					if(o=='clicktime'){
						this.ruleForm.clicktime = obj[o];
						this.ro.clicktime = true;
						continue;
					}
					if(o=='clicknum'){
						this.ruleForm.clicknum = obj[o];
						this.ro.clicknum = true;
						continue;
					}
					if(o=='discussnum'){
						this.ruleForm.discussnum = obj[o];
						this.ro.discussnum = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			lyricChange(e) {
				this.ruleForm.lyric = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			faxingriqiChange(e) {
				this.ruleForm.faxingriqi = e.target.value;
				this.$forceUpdate();
			},

			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			yinlefenleiChange(e) {
				this.yinlefenleiIndex = e.target.value
				this.ruleForm.yinlefenlei = this.yinlefenleiOptions[this.yinlefenleiIndex]
			},

			songfileTap () {
				let _this = this;
				this.$api.uploadMedia(function(res) {
					_this.ruleForm.songfile = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
			fengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fengmian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				if((!this.ruleForm.songname)){
					this.$utils.msg(`歌名不能为空`);
					return
				}
				if((!this.ruleForm.yinlefenlei)){
					this.$utils.msg(`音乐分类不能为空`);
					return
				}
				if((!this.ruleForm.bianqu)){
					this.$utils.msg(`编曲不能为空`);
					return
				}
				if((!this.ruleForm.songfile)){
					this.$utils.msg(`音乐文件不能为空`);
					return
				}
				if((!this.ruleForm.singer)){
					this.$utils.msg(`歌手不能为空`);
					return
				}
				if(this.ruleForm.shizhang&&(!this.$validate.isNumber(this.ruleForm.shizhang))){
					this.$utils.msg(`时长应输入数字`);
					return
				}
				if(this.ruleForm.thumbsupnum&&(!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))){
					this.$utils.msg(`赞应输入整数`);
					return
				}
				if(this.ruleForm.crazilynum&&(!this.$validate.isIntNumer(this.ruleForm.crazilynum))){
					this.$utils.msg(`踩应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`yinlexinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`yinlexinxi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`yinlexinxi`, this.ruleForm);
						}

						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`yinlexinxi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`yinlexinxi`, this.ruleForm);
					}

					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">影视名称</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yingshimingcheng" v-model="ruleForm.yingshimingcheng" placeholder="影视名称"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">影视分类</view>
				<picker :disabled="ro.yingshifenlei" :style='{"border":"2rpx solid #D9DADC","padding":"0 20rpx","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","width":"100%","height":"auto"}' @change="yingshifenleiChange" :value="yingshifenleiIndex" :range="yingshifenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#43B3BE"}' class="uni-input">{{ruleForm.yingshifenlei?ruleForm.yingshifenlei:"请选择影视分类"}}</view>
				</picker>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="" @tap="shipinTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">视频</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' v-if="ruleForm.shipin"  v-model="baseUrl+ruleForm.shipin" placeholder="视频"></input>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">导演</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.daoyan" v-model="ruleForm.daoyan" placeholder="导演"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">参与演员</view>
				<input :style='{"border":"2rpx solid #D9DADC","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.canyuyanyuan" v-model="ruleForm.canyuyanyuan" placeholder="参与演员"  type="text"></input>
			</view>
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 20rpx 0","alignItems":"flex-start","display":"flex","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">上映日期</view>
				<picker  :disabled="ro.shangyingriqi" :style='{"border":"2rpx solid #D9DADC","padding":"0 20rpx","borderRadius":"8rpx","flex":"1","background":"#F8F8F8","width":"100%","height":"auto"}' mode="date" :value="ruleForm.shangyingriqi" @change="shangyingriqiChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#43B3BE"}' class="uni-input">{{ruleForm.shangyingriqi?ruleForm.shangyingriqi:"请选择上映日期"}}</view>
				</picker>
			</view>
              
			<view :style='{"width":"100%","padding":"12rpx 0","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">影视介绍</view>
				<xia-editor ref="yingshijieshao" :style='{"minHeight":"300rpx","border":"2rpx solid #D9DADC","padding":"20rpx","borderRadius":"8rpx","background":"#F8F8F8","width":"calc(100% - 160rpx)","height":"auto"}' v-model="ruleForm.yingshijieshao" placeholder="影视介绍" @editorChange="yingshijieshaoChange"></xia-editor>
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
				yingshimingcheng: '',
				yingshifenlei: '',
				fengmian: '',
				shipin: '',
				daoyan: '',
				canyuyanyuan: '',
				shangyingriqi: '',
				yingshijieshao: '',
				discussnum: '',
				storeupnum: '',
				},
				yingshifenleiOptions: [],
				yingshifenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   yingshimingcheng : false,
				   yingshifenlei : false,
				   fengmian : false,
				   shipin : false,
				   daoyan : false,
				   canyuyanyuan : false,
				   shangyingriqi : false,
				   yingshijieshao : false,
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
			this.ruleForm.shangyingriqi = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`yingshifenlei`,`yingshifenlei`,{});
			this.yingshifenleiOptions = res.data;
			this.yingshifenleiOptions.unshift("请选择影视分类");

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
				res = await this.$api.info(`yueyuyingshi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='yingshimingcheng'){
						this.ruleForm.yingshimingcheng = obj[o];
						this.ro.yingshimingcheng = true;
						continue;
					}
					if(o=='yingshifenlei'){
						this.ruleForm.yingshifenlei = obj[o];
						this.ro.yingshifenlei = true;
						continue;
					}
					if(o=='fengmian'){
						this.ruleForm.fengmian = obj[o].split(",")[0];
						this.ro.fengmian = true;
						continue;
					}
					if(o=='shipin'){
						this.ruleForm.shipin = obj[o];
						this.ro.shipin = true;
						continue;
					}
					if(o=='daoyan'){
						this.ruleForm.daoyan = obj[o];
						this.ro.daoyan = true;
						continue;
					}
					if(o=='canyuyanyuan'){
						this.ruleForm.canyuyanyuan = obj[o];
						this.ro.canyuyanyuan = true;
						continue;
					}
					if(o=='shangyingriqi'){
						this.ruleForm.shangyingriqi = obj[o];
						this.ro.shangyingriqi = true;
						continue;
					}
					if(o=='yingshijieshao'){
						this.ruleForm.yingshijieshao = obj[o];
						this.ro.yingshijieshao = true;
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
			yingshijieshaoChange(e) {
				this.ruleForm.yingshijieshao = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			shangyingriqiChange(e) {
				this.ruleForm.shangyingriqi = e.target.value;
				this.$forceUpdate();
			},

			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			yingshifenleiChange(e) {
				this.yingshifenleiIndex = e.target.value
				this.ruleForm.yingshifenlei = this.yingshifenleiOptions[this.yingshifenleiIndex]
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
			shipinTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.shipin = 'upload/' + res.file;
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
				if((!this.ruleForm.yingshimingcheng)){
					this.$utils.msg(`影视名称不能为空`);
					return
				}
				if((!this.ruleForm.yingshifenlei)){
					this.$utils.msg(`影视分类不能为空`);
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
					let res = await this.$api.list(`yueyuyingshi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`yueyuyingshi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`yueyuyingshi`, this.ruleForm);
						}

						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`yueyuyingshi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`yueyuyingshi`, this.ruleForm);
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

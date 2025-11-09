<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","width":"100%","padding":"0","background":"url(http://codegen.caihongy.cn/20250205/f68f29e0b075460ab45edf5fe2a31b07.png) top center/cover","height":"auto"}'>
		<view :style='{"width":"100%","padding":"160rpx 40rpx 0","position":"relative","flexWrap":"wrap","display":"flex","height":"auto"}'>
			<image :style='{"width":"140rpx","margin":"20rpx auto 20rpx","borderRadius":"50%","display":"block","height":"140rpx","order":"1"}' src="http://codegen.caihongy.cn/20250205/0c407806221c4379822c477894da139d.png" mode="aspectFill"></image>
			<view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","width":"calc(100% - 160rpx)","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.zhanghao"  type="text"  class="uni-input" name="" placeholder="账号" />
			</view>
			<view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","width":"calc(100% - 160rpx)","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","width":"calc(100% - 160rpx)","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","width":"calc(100% - 160rpx)","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"100%","padding":"0 24rpx","margin":"0","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"lineHeight":"88rpx","fontSize":"28rpx","color":"#43B3BE","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">手机：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"none","width":"calc(100% - 160rpx)","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
            <view :style='{"margin":"0 auto 0","borderColor":"#000","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"width":"160rpx","padding":"0","lineHeight":"88rpx","fontSize":"24rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","margin":"10rpx 0","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","margin":"10rpx 0","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"10rpx","background":"#43B3BE","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx","order":"4"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"padding":"0 0 0 80rpx","color":"#000","background":"none","width":"100%","fontSize":"32rpx","fontWeight":"bold","height":"60rpx"}'>很高兴认识你</view>
			<view class="idea2" :style='{"padding":"0 0 0 80rpx","color":"#585858","background":"none","width":"100%","fontSize":"30rpx","fontWeight":"bold","height":"auto"}'>Nice to meet you</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                shouji: '',
                touxiang: '',
                shhf: '',
				money: 0,
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
					this.$utils.msg(`姓名不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

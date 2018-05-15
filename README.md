# OneXClient
#### 1、BottomNavigationView的使用中出现的bug
--确保在Drawable中找到相应的资源文件，尤其是在android视图下面更难发现，添加依赖design包时，注意版本号相同的问题
#### 2.解决git提交上传的时候出现断网，这个时候显示无法push，不用担心，当我们下次进行push的时候，git会自动的去push之前没有成功的分支

#### 3.数据bean的基础封装的使用，将最外层的嵌套的bean，删除掉，保留里面真实的数据bean，类似于Article的实现

Error:Execution failed for task ':app:transformResourcesWithMergeJavaResForDebug'
解决方法
```
 packagingOptions {
     exclude 'META-INF/LICENSE'
     exclude 'META-INF/DEPENDENCIES'
 }

```

#### 4. All com.android.support libraries must use the exact same version specification (mixing versions can lead to runtime crashes). Found versions 27.0.2, 26.1.0. Examples include com.android.support:support-compat:27.0.2 and com.android.support:animated-vector-drawable:26.1.0 less... (Ctrl+F1)
根build中强制进行转化相应的类

#### rxjava-adapter 的依赖错误  Could not locate call adapter for io.reactivex.Observable

#### 多个observable进行网络请求的时候，像登录和注册这种相关的请求，数据中直接放回response对象，在subscribe中进行处理相关的逻辑

#### 研究实现请求中cookie的使用，在项目中的实际使用的方式，以及网络数据的持久化操作


#### 单独定义字体的font.xml在布局中仍然使用  @dimen/xxsp照样可以引用的到，类似于颜色的引用

#### dagger2是不是有更新，所有的使用全是用@inject注解全部实现？

#### 关于toolbar的使用总结，在baseActivity中直接进行初始化，比如定义为  toolbar ,子布局中药继承的Activity中都进行手动配置这个toolbar
及布局文件中进行写一个相关的id 为toolbar的  ToolBar的控件，这样不会报空，又会单独处理

#### 将Page页面的索引，全部写在presenter中，实现View与Presenter之间的解耦

#### SearchView的使用总结，

#### 历史搜索功能的详细实现

#### 下一步计划，进行实现豆瓣API的接入

#### 集成定位和地图的操作


####     android:foreground="@drawable/item_touch_bg" cardView的bug

#### cardview的点击事件选择背景的效果

#### 每页的数量与baseFragment中的要对应一致

#### glide 3.X和4.X的版本，3.X提供相关的api支持预加载时显示的图片，和过度的动画，而4.X中这些属性全都去掉了

#### baseRecycleViewAdapterHelper中的加载更多视图的开关和自定义加载视图的效果

#### 创建公共的loadingView
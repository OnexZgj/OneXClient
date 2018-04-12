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
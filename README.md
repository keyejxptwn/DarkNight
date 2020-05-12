# Android 10深色模式
### 在Android10(API 29)中加入了深色主题，官方称之为Dark Theme，深色主题背景具有诸多优势：

 - 可大幅减少耗电量（具体取决于设备的屏幕技术）主要是OLED屏幕黑色不发光。
 - 为弱视以及对强光敏感的用户提高可视性。
 - 让所有人都可以在光线较暗的环境中更轻松地使用设备。

### 在 Android 10 (API 级别 29) 及更高版本中，您可以通过以下三种方法启用深色主题背景：

 - 使用系统设置（Settings -> Display -> Theme）启用深色主题背景。
 - 使用“快捷设置”图块，从通知托盘中切换主题背景（启用后）。 
 - 在 Pixel设备上，选择“省电模式”将同时启用深色主题背景。其他原始设备制造商 (OEM) 不一定支持这种行为。
 
### 在应用中支持深色主题背景
应用的主题背景（通常可在 res/values/styles.xml 中找到）设置为继承 ``` DayNight ```主题背景：
```xml
<style name="AppTheme" parent="Theme.AppCompat.DayNight">
```
或者使用MaterialComponent 的深色主题背景
```xml
<style name="AppTheme" parent="Theme.MaterialComponents.DayNight">
```
### 主题背景和样式
 - ```?android:attr/textColorPrimary ```   这是一种通用型文本颜色。它在浅色主题背景下接近于黑色，在深色主题背景下接近于白色。该颜色包含一个停用状态。
 - ```?attr/colorControlNormal ```一种通用图标颜色。该颜色包含一个停用状态。
### 文字颜色
 - 在```res```文件中新建```value-night```文件夹,新建名为```color.xml```和```style.xml```,或者拷贝```value```中的对应文件
 - - ```value-night```中的```style.xml```中的```AppTheme```继承自```Theme.AppCompat.DayNight```或者```Theme.MaterialComponents.DayNight```
   - ```value-night```中的```style.xml```中的```color```输入对应深色模式的颜色值，名字需要保持一致
### 图片
例如：```drawable```文件夹下有一张```test.webp```的图片,此时你需要新建一个```drawable-night```的文件夹，在里面放入深色对应的图片， ***图片名称一定要和drawable中的保持一致***。同理，```drawable-xhdpi```、```mipmap-xhdpi```就是建立对应深色模式的文件夹：```drawable-night-xhdpi```、```mipmap-night-xhdpi```然后放入对应图片文件即可。
### 应用在 Android 10 (API 级别 29) 及更高版本上运行时，推荐的选项有所不同，目的是允许用户替换系统默认设置：
- 浅色 - ```MODE_NIGHT_NO```
- 深色 - ```MODE_NIGHT_YES```
- 由省电模式设置 - ```MODE_NIGHT_AUTO_BATTERY```
- 系统默认 - ```MODE_NIGHT_FOLLOW_SYSTEM```
### 代码设置
```AppCompatDelegate```请参阅[Google Docs - AppCompatDelegate][1]
```java 
AppCompatDelegate.getDefaultNightMode();//获取当前显示的模式
AppCompatDelegate.setDefaultNightMode(mode == MODE_NIGHT_YES ? MODE_NIGHT_NO : MODE_NIGHT_YES);//切换深色模式和关闭
```
### 以上就是简单设置深色模式的方法，欢迎指正，提出建议      
aaaaaaaaaa


  [1]: https://developer.android.com/reference/androidx/appcompat/app/AppCompatDelegate

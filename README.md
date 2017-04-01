摘要：在Android布局中经常需要复用title布局，但是每次定义很麻烦，并且如果哪天即便只需要修改一个背景就会让你抓狂了，并且每个title只是内容不一样，一般只有左边按钮，中间文字和左边按钮，所以我们可以自定义一个TopBar，以便每次复用。

1.首先自定义控件需要分析需要哪些属性，这里就简单的写了几个，有文字大小，颜色和内容等，然后仿照系统的处理方法创建一个attrs.xml文件在里面声明一下。
 
2.然后创建一个TopBar类集成系统的View/ViewGroup，这里当然选择继承RelativeLayout了，在这里面的构造方法中完成对声明的属性的获取与使用。
  
3.然后就可以在布局中使用它了，当然了不能忘记这句命名空间代码了（xmlns:topBar="http://schemas.android.com/apk/res-auto"）：
     <topbar.tomcode.com.topbar.TopBar
        android:id="@+id/topbar"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        topBar:CenterText="中间标题"
        topBar:CenterTextColor="#00ff00"
        topBar:CenterTextSize="12dp"
        topBar:LeftButtonBackground="#ffd300"
        topBar:LeftButtonText="左边"
        topBar:LeftButtonTextColor="#ff0000"
        topBar:RightButtonBackground="#ffd300"
        topBar:RightButtonText="右边"
        topBar:RightButtonTextColor="#ff0000" />
4.以上就完成了最基本的功能。

5.当然点击事件也是必不可少的，这里需要自己仿照系统的来定义：

6.首先定义一个接口：
   
7.触发监听的方法，最好能判断下监听者是否为空，这里不再判断了：
   
8.暴露给使用者一个方法，同时需要使用者传给我一个监听者对象，以便使用这个对象去监听。
     
9.使用点击事件，和系统的一样一样的
     
10.当然还可以添加一些隐藏按钮的方法，以便在不需要的时候隐藏掉，这里不再赘述，只是起一个抛砖引玉的作用。

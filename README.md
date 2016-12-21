
### IntelliJ の場合

- project structure から Java SDKの設定を行う
- File > Open から対象プロジェクトを選択
- Gradleのプロジェクト設定画面が表示されるので
    - auto importにチェック
    - use gradle wrapper にチェックが入っていることを確認
    - OKすると自動でプロジェクトインポートが始まります
- View > tool windows から Gradleを選択
    - 右側にGradleタスクウィンドウが開きます。
    - application > bootrun が使えるようになります
    - build > warまたはjar でビルドできるようになります
    - 必要に応じて使用してください
- IntellijIDEA > preferance > Plagins で「lombok」を検索
    - リポジトリから検索
    - lombok pluginをインストールしてrestart
- FileUploadController.javaか何かを開いてみてエラーがでてなければOK
- bootrunしてアプリを実行し、topページが表示されれば設定完了
    - http://localhost:8080/gallery

### eclipseの場合

- project import で多分gradleプロジェクトインポートできる・・・はず・・・
    - all in one 4.4(以下プラグイン設定済みの状態で) でgradleプロジェクトインポートで行けたと報告ありました
- 実行タスク「bootrun」で、アプリを実行する。topページが表示されれば設定完了
    - http://localhost:8080/gallery
    - 右クリック＞Gradle＞クイックランチャー＞bootrun直打ちして実行
- all in one 4.5以下の場合、もしくはall in oneを使用していない場合は以下プラグインの設定を行ってください
    - EGit
    - STS(Spring Tool Suite)
- all in one 4.4以下の場合、もしくはall in oneを使用していない場合は以下ブラグインの設定を行ってください
    - Gradle IDE もしくは Buildship
        
### その他共通

- Gradleはプロジェクト内にwrapperを用意しているので別途インストールしておく必要はありません
- TomcatはSpringBoot内の組み込みTomcatを使用しているため、別途インストールや起動をする必要はありません
    - むしろ起動しているとおかしな動作をする場合があるので、別にTomcatを起動している方は停止しておいてください

# kotlin-playground

Spring Boot + Kotlin の Web アプリケーションを動かせるプレイグラウンド！

## 構成

| 項目                | 説明                     |
|-------------------|------------------------|
| Spring Boot 3.2.2 | フレームワーク                |
| Kotlin            | 言語                     |
| PostgreSQL        | データは永続化                |
| MyBatis           | アプリから DB を操作する OR マッパー |
| Thymeleaf         | テンプレートエンジン             |
| DevTools          | ホットリロードに対応             |
| Docker            | コンテナ上でアプリを動かす          |

## 環境構築手順

### 前提

下記が必要です。

- [Docker](https://www.docker.com/ja-jp/products/docker-desktop/)
- [IntelliJ IDEA CE](https://www.jetbrains.com/ja-jp/idea/download/?section=mac)

### 1.プロジェクトのクローン

任意のディレクトリでクローンする。

```zsh
git clone git@github.com:tes-inc/kotlin-playground.git
```

プロジェクトディレクトリに移動する。

```zsh
cd kotlin-playground
```

### 2. Docker で環境をビルド

```zsh
docker compose build
```

実行が終わったら http://localhost:8080/users にアクセスして簡素な User List 画面が表示されることを確認する。

問題なければいったん Ctrl + C でコンテナを停止させる。

環境構築としては以上でおわり。

## 環境構築後の実行方法

前提として、プロジェクトフォルダを IntelliJ で開いてること。

#### Docker コンテナを IntelliJ から実行する

IntelliJ の右上にある実行構成の一覧から「ぷれいぐらうんど」を選択して実行ボタンを押す。

#### デバッグモード起動設定

IntelliJ の右上にある実行構成の一覧から「ぷれでばっぐ」を選択して実行ボタンを押す。

デバッグモードでアプリケーションが起動するので、エディタ上でブレイクポイントを付ければデバッグが普通にできる。

# REST API 勉強会

## アジェンダ
- [目的共有](##目的)
- [REST API の基本を知ろう](##restapiの基本)
    - REST API ガイドライン
    - API 設計
- [REST API 実装してみよう](##restapiを実装してみよう)
    - テーマ説明
    - コード説明
    - TODO 説明
- [その他](##その他)

## 目的
- REST API の設計がなんとなくできるようになる
- 本業以外で Scala で新しいものにちょっと触れてみる
- DDD ぽいことちょっとやる

## REST API の基本
- ガイドライン
    - まずは世の中に出ている情報を参考する
    - [Representational State Transfer](https://ja.wikipedia.org/wiki/Representational_State_Transfer)
    - Qiita
        - [REST入門 基礎知識](https://qiita.com/TakahiRoyte/items/949f4e88caecb02119aa)
        - [0からREST APIについて調べてみた](https://qiita.com/masato44gm/items/dffb8281536ad321fb08)
        - [翻訳: WebAPI 設計のベストプラクティス](https://qiita.com/mserizawa/items/b833e407d89abd21ee72)
            - > 関連データがリソースから独立して存在する場合は、リソースのアウトプットに関連データの ID を含めるのが良いです。API 利用者はその内容を見て、関連データのエンドポイントにアクセスすることとなります。とはいえ、親データと関連データが大体一緒に使われるようであれば、レスポンスに関連データを埋め込めるようにしておいて、何度もリクエストする手間を省いてもいいかもしれません。
            - > PUT /gists/:id/star
        - [PUT か POST か PATCH か？](https://qiita.com/suin/items/d17bdfc8dba086d36115)
    - [REST API Tutorial](https://restfulapi.net/http-methods/)
    - [Google API Guidelines](https://cloud.google.com/apis/design/?hl=ja)
    - [Microsoft API Guidelines](https://github.com/Microsoft/api-guidelines/blob/vNext/Guidelines.md)
    - [Uber API Reference](https://developer.uber.com/docs)
    - [WordPress REST API Resources](https://developer.wordpress.com/docs/api/)
    - [Shipwire API Reference](https://www.shipwire.com/w/developers/) 
- REST はあくまで設計原則
    - 画面都合でではなくリソース指向で設計する
    - リソースへの操作を URI と HTTP メソッドで対応づける
    - リソースを URI で特定できるようにする
        - URI に現れるのは基本的に名詞
        - 操作は HTTP メソッドで表す
    - 1画面で複数リソースを必要とする場合は画面が複数 API を呼び出す
        - ~~そもそもそういう仕様の時点で複雑なので仕様を見直すべきかもしれないが~~
        - ユースケースにあわせたエンドポイントも必要だと思う
    - サービスのアーキテクチャによっても REST API の設計は変わると思う
        - POST で 201 を返すのか 202 を返すのか
        - コールバック URI を返す
        - ページング
        - ~~200 OK でエラーメッセージ~~
        - 認証
    - XML？HTML？JSON！
- HTTP メソッドとリソースへの操作の対応
    - | HTTP メソッド | リソースへの操作  | レスポンスボディ (ステータス)                                       | URIの例                           | 備考                            |
      | :---------: |:--------------: | :-------------------------------------------------------------: | :------------------------------: | :------------------------------:|
      | GET         | 参照            | リソースあるいはリソースの一覧 (200 OK)                              | /items, /items/:id/details       |                                 |
      | POST        | 作成            | 作成されたリソース/リソースID） (200 OK, 201 Created, 202 Accepted)  | /items, /items:id/details/:id    | べき等ではない、作成以外でも使われる |
      | PUT         | 置換または作成    | 作成されたリソースまたは ID (200 OK) or なし (204 No Content)        | /items/:id, /items:id/details/:id | べき等                          |
      | PATCH       | 部分置換         | なし (204 No Content)                                            | /items/:id, /items:id/details/:id | べき等                          |
      | DELETE      | 削除            | なし (204 No Content)                                            | /items/:id, /items:id/details/:id |                                |
    - [ステータスコード](https://ja.wikipedia.org/wiki/HTTP%E3%82%B9%E3%83%86%E3%83%BC%E3%82%BF%E3%82%B9%E3%82%B3%E3%83%BC%E3%83%89)
    - [RESTful API設計におけるHTTPステータスコードの指針](https://qiita.com/uenosy/items/ba9dbc70781bddc4a491)
- その他
    - REST API のとあるエンドポイントは他のマイクロサービスやフロントエンドから利用されるドメインサービス
        - アプリケーション全体で DDD を実現する
        - ページングがレスポンスに含まれるべきではない
        - フロントでドメインモデルを再構築することの無駄感
            - GraphQL
        - トランザクション境界をリソースの単位にすると良いかも

## REST API 実装

### コード説明
- [このリポジトリ](https://github.com/pauljamescleary/scala-pet-store)をパクりました

### エンドポイント一覧

#### authentication api (/auth)
| URI         | HTTP Method  | Description          |
| :---------: |:-----------: |:-------------------: |
| /signup     | POST         | 乗客アカウント登録      |
| /login      | POST         | 乗客アカウントでログイン |

#### passenger api (/passenger)
| URI                           | HTTP Method  | Description          |
| :---------------------------: | :----------: | :------------------: |
| /me                           | GET          |                      |
| /landmarks                    | POST         | ランドマーク一覧登録    |
| /landmarks                    | GET          | ランドマーク一覧取得    |
| /trips                        | POST         |                      |
| /trips/current                | GET          |                      |
| /trips/current/changeRequests | POST         |                      |

#### vehicle api (/vehicle)
| URI                                     | HTTP Method     | Description          |
| :-------------------------------------: |:--------------: |:-------------------: |
| /me                                     | GET             |                      |
| /location                               | PUT             |                      |
| /operations                             | GET             |                      |
| /operations/current                     | GET             |                      |
| /operations/current/schedules/:id/done  | PUT             |                      |
| /trips/:id                              | PUT             |                      |

#### operator api (/operator)
| URI         | HTTP Method   | Description          |
| :---------: | :-----------: |:-------------------: |
|             |               |                      |

## その他
- ICONIX
    - 要求
        - 「xxxするためにyyyできること」
    - 要件
        - 要求の中から実現したいものを絞る
    - ユースケース図
        - システムでできることを定義する
    - ユースケース記述
        - 操作説明資料を書いているような抽象度
        - システムとアクターのインタラクション
    - ドメインモデル
        - データモデルではない
        - 境界を定める
        - 用語を定義する
    - 相互作用（ロバストネス図）
        - 分析、詳細設計
        - control からクラスのメソッドを見つける
            - システムでやることが control として現れる
        - boundary から画面やエンドポイントを見つける
        - ドメインモデルに不足している entity を見つける
        - 重複している control 群をユースケースとしてまとめる 

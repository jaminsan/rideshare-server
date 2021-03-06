## 機能

### 乗客アカウント
- 乗客アカウント登録できること
    - 以下の内容を入力すること
        - 名前
        - 電話番号
        - メールアドレス
- ランドマークを登録できる
    - よく行く場所を登録する
    - ランドマークとは目印という意味合い
    - 以下の内容を入力すること
        - 名前
        - 緯度経度

### 配車
- ユーザが配車依頼できること
    - 配車依頼時には以下の内容を入力する
        - 依頼者情報
            - 名前
            - 電話番号
        - 乗車人数
            - サービス開始当初は1人で固定
        - 乗車地点
            - 緯度・経度
        - 降車地点
            - 緯度・経度
        - 希望時刻（任意）
            - 希望乗車時刻か希望降車時刻のいずれか一方のみ指定可能
                - 希望乗車時刻
                    - 指定した時刻以降に乗車地点に到着するようにする
                    - 降車時刻はシステムが決定する
                - 希望降車時刻
                    - 指定した時刻までには乗客が降車できるようにする
                    - 乗車時刻はシステムが決定する
            - 希望時刻の指定がない場合
                - とにかくすぐ乗りたいという場合は指定なしにすると良い
                - 乗車時刻
                    - 車両が到着できるもっとも早い時刻となる
                - 降車時刻
                    - 最短移動時間 + 乗合バッファ時間
     - 乗降地点の選択
        - ランドマークから選択する
- ユーザが自分の配車依頼を閲覧できること
    - 以下の内容を閲覧できること
        - 処理状態に応じて閲覧できる内容が異なる
            - 受理
                - 運行情報
            - 拒否
                - 拒否理由
                    - 乗降地点の指定場所が不適切
                    - 配車できる車両が見つからなかった
                    - 希望時刻を満たす配車ができなかった
            - 処理中
    - 最新の一件を取得できること
- 配車依頼をキャンセルできること
    - 処理状態が「処理中」の配車依頼をキャセンルできる
    - キャンセル料は発生しない

### 運行
- 配車依頼をもとに運行を調整できること
    - 配車可否の判定
        - 配車依頼は「処理中」の状態で運行計算されその結果「受理」もしくは「拒否」のいずれかの状態になる
            - 配車予約が受理された場合
                - 配車予約が運行に紐づけられる
                - １つの配車予約に対してルートが作成される
                    - ルートには乗客の乗車〜降車までの間の経由地点の情報を持つ
                    - 乗合しているかどうかはこのルートを見ることでわかる
        - 以下の情報をもとに配車可否を判定する
            - 現在の運行
            - 車両の稼働状況
                - 現在位置
                - 休憩状態
                - 最大乗車人数
            - 配車予約の制約
            - 制約
                - 運行に含まれる全ての乗車地点に対して、予想到着時刻が希望乗車時刻より前にならないこと
                - 運行に含まれる全ての降車地点に対して、予想到着時刻が希望降車時刻より後にならないこと
                - 運行全体で車両の最大乗車人数を超える乗合をしないこと
                - 可能な限り乗合を増やすこと
                - 車両の総走行距離が最小になるような運行にすること
                - 休憩状態の車両には配車しないこと
    - 車両に運行を割り当てる
        - 複数の配車予約を束ねた運行ルートを持つ
        - 運行ルートは経由地点を持ち到着時刻が早い順に経由する必要がある
        - 経由地点には乗車地点と降車地点がありそれぞれ乗客の乗車と降車を行う
- 配車予約に対する運行を閲覧できること
    - 以下の内容を閲覧できること
        - 運行状態
            - 迎車中
                - 乗客を乗車地点に迎えに行っている状態
            - 車両到着
                - 車両が乗車地点に到着した状態
            - 実車中
                - 乗客が車両に乗車した状態
            - 送迎完了
                - 車両が降車地点に到着して乗客が降車した状態
        - 乗車地点
            - 緯度経度
            - 希望時刻
            - 予約時予想到着時刻
            - 最新予想到着時刻
        - 降車地点
            - 緯度経度
            - 希望時刻
            - 予約時予想到着時刻
            - 最新予想到着時刻
        - ルート
            - 乗合による遠回りを含めた経由地点の情報
- 遅延中の運行を閲覧できること
    - 遅延の定義
        - 乗車
            - 現在時刻が予想到着時刻を超えているが運行状態が車両到着となっていない
        - 降車
            - 現在時刻が予想到着時刻を超えているが運行状態が送迎完了となっていない
    - 以下の内容を閲覧できること
- 車両に割り当てられている運行を閲覧できること
    - 以下の内容を閲覧できること
        - 運行ルート
        - 配車予約
- 運行のステータスを変更できること
    - 乗車地点への到着
    - 乗客の乗車
    - 乗客の降車

### 車両
- 車両を登録できること
    - 以下の情報を入力すること
        - 車両番号
        - 最大乗車人数
- 車両の稼働状態を変更できること
    - 稼働状態
        - 休憩中
        - 稼働中
- 車両の現在位置を更新できること
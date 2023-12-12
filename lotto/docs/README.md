# 기능 목록

### 요구 사항
- 로또 숫자 범위 1 ~ 45
- 중복되지 않는 6개의 숫자
- 당첨 번호 추첨 시 숫자 6개와 보너스 번호 1개
- 당첨은 1등부터 5등까지
  - 1등: 6개 번호 일치 2,000,000,000
  - 2등: 5개 번호 + 보너스 번호 일치 30,000,000
  - 3등: 5개 번호 일치 1,500,000
  - 4등: 4개 번호 일치 50,000
  - 5등: 3개 번호 일치 5,000
  
- 구입 금액 만큼 로또 발행
- 로또 1장 가격 1,000
- 당첨 번호와 보너스 번호 입력
- 사용자와 당첨 번호 비교 -> 당첨 내역 및 수익률 출력

## 개발 순서
1. 로또 구입, 로또 번호 출력 - O
2. 당첨 번호 및 보너스 번호 입력 - O
3. 사용자 번호와 비교 기능 구현 - O
4. 통계 결과 출력 - O
5. 수익률 계산 - O
6. 수익률 출력 - O
7. 예외 처리 구현 - X

### 입력 - InputView
- 금액 입력(1000원 단위 - 나누어 떨어지기! 안되면 예외 ) - readAmount()
- 당첨 번호 입력(쉼포 구분) - readWinningNumber() - readWinningNumber()
- 보너스 번호 입력 - readBonusNumber() - readBonusNumber()

### 출력 - OutputView
- 발행한 로또 수량 및 번호 출력(로또 오름 차순 정렬)
  - 구매한 로또 수량 출력 - printPurchaseLottoSummary()
  - 구매한 로또 번호 출력 - printPurchaseLottoNumbers()
- 당첨 내역 출력 (3 -> 6개) - printWinningDetails()
- 수익률 출력(소수점 둘째 자리 반올림) - printTotalProfit()

### 로또 - Lotto
- 로또 숫자를 반환하는 기능 - getLottoNumber()

### 사용자 - Player

### 판매자 - Seller
- 로또를 판매하는 기능 - sellLotto()

### 숫자 생성기 - NumberGenerator
- 숫자를 생성하는 기능 - generateNumber()

### 심판 - Referee
- 당첨 번호에 포함되는 숫자를 반환하는 기능 - getContainNumber()
- 당첨인지 판단하는 기능 추가 - judeWinning()

### 로또 게임 - LottoGame
- 로또 게임을 시작하는 기능
- 심판을 생성하는 기능
- 총 상금을 계산하는 기능
- 수익률을 계산하는 기능
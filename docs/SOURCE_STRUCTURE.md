# JavaStudy 소스 구조 점검

## 점검 범위

- 저장소: `kmaxjang/JavaStudy`
- 기준 브랜치: `master`
- 점검일: 2026-10-25
- 목적: 기존 Java 소스의 위치와 패키지 역할을 파악하고, 안전한 구조 정리 기준을 기록한다.

이번 점검은 GitHub 코드 검색과 일부 파일 확인을 기준으로 한다. 저장소 전체 파일 트리를 완전하게 열람한 것은 아니므로 아래 목록은 **확인된 파일의 예시이며 전체 목록이 아니다.**

## 확인된 패키지와 파일 예시

| 패키지 | 확인된 파일 | 현재 판단 |
| --- | --- | --- |
| `com` | `MainClass.java` | 공통 진입점 또는 간단한 연습 코드로 보임. 실제 역할 추가 확인 필요 |
| `com.cell` | `Search.java`, `MainCell.java` | 배열 검색 및 데이터 생성 관련 코드가 있음 |
| `com.lotto` | `LottoMain.java`, `Rule.java`, `Ex.java`, `TestMain.java` | 로또 관련 코드로 보임 |
| `com.frame` | `Loop.java`, `Delay.java` | 반복 처리 및 시간 지연 관련 코드가 있음 |
| `com.game2` | `GameMain.java`, `GamePanel.java`, `Config.java` | 게임 화면/설정 코드가 있음 |
| `com.note9` | `FPS.java`, `Lotto.java`, `Numbers.java`, `EditData.java`, `ByteClass.java` | 여러 종류의 코드가 함께 있어 하위 주제 분류 여부 검토 필요 |
| `com.fps` | `FPS.java` | `com.note9.FPS`와 이름이 겹침. 중복인지 별도 구현인지 비교 필요 |
| `com.ex5` | `Lock.java`, `Condition.java` | 인터페이스 및 조건 관련 코드가 있음 |

## 정리 원칙

1. 기존 `master` 브랜치와 작업 중인 브랜치를 직접 변경하거나 삭제하지 않는다.
2. 파일 이동이나 패키지명 변경은 import, 실행 진입점, 빌드 설정에 영향을 줄 수 있으므로 전체 참조를 확인하기 전에는 하지 않는다.
3. 주제별 학습 예제는 목적이 서로 다를 수 있으므로 이름이 비슷하다는 이유만으로 합치지 않는다.
4. 새 구조 변경은 별도 브랜치에서 진행하고, 변경 전후 파일 목록과 검증 결과를 남긴다.
5. Java 8 호환성은 구조 정리와 별도 항목으로 검사한다.

## 권장 후속 작업

- 저장소 전체 파일 트리와 루트 설정 파일을 확인한다.
- 각 패키지의 역할을 README 또는 이 문서에 보완한다.
- `com.note9.FPS`와 `com.fps.FPS`의 차이를 확인한다.
- `com.cell.Search`의 검색 알고리즘을 별도 코드 검토 대상으로 둔다.
- 역할이 확인된 뒤에만 파일 이동이나 패키지 이름 변경을 제안한다.

## 현재 적용 범위

이 문서는 구조 점검 결과를 기록하기 위해 추가되었다. 기존 Java 소스 파일은 이동·수정·삭제하지 않았다.

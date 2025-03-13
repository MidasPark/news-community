### [< ReadMe로 돌아가기](../readme.md)
___

# Git 브랜치 전략

## 1. 주요 브랜치

### main
- 항상 배포 가능한 상태를 유지하는 브랜치
- 최종 릴리스된 코드가 저장됨

### develop
- 개발 중인 최신 코드가 저장되는 브랜치
- 새로운 기능(feature)과 수정 사항이 병합되며, 안정적인 상태를 유지해야 함

## 2. 보조 브랜치

### feature/ISSUE-<번호>
- 새로운 기능 개발을 위한 브랜치
- `develop`에서 분기하며, 작업이 완료되면 다시 `develop`으로 병합됨
- 예: `feature/ISSUE-123`

### release/<버전명>
- 배포 준비를 위한 브랜치
- `develop`에서 분기하며, QA 및 버그 수정을 진행한 후 `main`과 `develop`에 병합됨
- 예: `release/1.0.0`, `release/2.1.3`

### hotfix/ISSUE-<번호>
- 배포된 코드에서 긴급한 버그를 수정하기 위한 브랜치
- `main`에서 분기하며, 수정 후 다시 `main`과 `develop`에 병합됨
- 예: `hotfix/ISSUE-456`

## Git Flow를 사용할 때의 작업 흐름

### 새로운 기능 개발
- `develop`에서 분기 → `feature/ISSUE-<번호>` 생성 → 작업 완료 후 `develop`에 병합

### 릴리스 준비
- `develop`에서 분기 → `release/<버전명>` 생성 → QA 및 수정 완료 후 `main`과 `develop`에 병합

### 긴급 버그 수정
- `main`에서 분기 → `hotfix/ISSUE-<번호>` 생성 → 수정 완료 후 다시 `main`과 `develop`에 병합

---
### [< ReadMe로 돌아가기](../readme.md)

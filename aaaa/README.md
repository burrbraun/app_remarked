[![pipeline status](https://git.t8h.io/tt/xqa/ttnetwork/badges/XQA-638/pipeline.svg)](https://git.t8h.io/tt/xqa/ttnetwork/-/commits/master)
[![coverage report](https://git.t8h.io/tt/xqa/ttnetwork/badges/XQA-638/coverage.svg)](https://git.t8h.io/tt/xqa/ttnetwork/-/commits/master)
[![ktlint](https://img.shields.io/badge/ktlint%20code--style-%E2%9D%A4-FF4081)](https://pinterest.github.io/ktlint/)

TalentTech: XQA-TTNetwork
=====================

##### Lightweight http client with methods for testing. A simple test looks like this:
```kotlin
TTNetwork().getHttpClient().get("http://example.com/users")
    .shouldBe(
        Condition.codeEquals(200), 
        Condition.bodyParamEquals("count", 100)
)
```

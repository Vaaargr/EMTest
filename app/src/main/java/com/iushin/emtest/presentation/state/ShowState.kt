package com.iushin.emtest.presentation.state

import com.iushin.domain.models.Response

sealed class ShowState(val response: Response) {
    class Preview(val prevResponse: Response, val count: Int): ShowState(prevResponse)
    class FullShow(val fullResponse: Response): ShowState(fullResponse)
}
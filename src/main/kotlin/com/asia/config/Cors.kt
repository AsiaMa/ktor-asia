package com.asia.config

import io.ktor.features.*
import io.ktor.http.*

fun CORS.Configuration.cors() {
    // By default, the CORS plugin allows the GET, POST and HEAD HTTP methods.
    method(HttpMethod.Options)
    method(HttpMethod.Put)
    method(HttpMethod.Patch)
    method(HttpMethod.Delete)

    // The CORS plugin allows the following client headers by default: Accept; Accept-Language; Content-Language; Content-Type
    header(HttpHeaders.ContentType)
    header(HttpHeaders.Authorization)
    header(HttpHeaders.AccessControlAllowHeaders)
    header(HttpHeaders.AccessControlAllowOrigin)

    // allow custom headers
    allowHeaders { name ->
        name == "abc"
    }
    allowHeadersPrefixed("custom-")

    // By default, browsers don't send credential information (such as cookies or authentication information) with cross-origin requests.
    // To allow passing this information
    // allowCredentials = true

    allowSameOrigin = true

    // cache preflight request
    maxAgeInSeconds = 3600

    // allowNonSimpleContentTypes = true

    // maxAgeDuration = Duration.days(1)

    anyHost()
}
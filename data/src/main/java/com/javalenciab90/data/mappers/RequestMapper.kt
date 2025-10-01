package com.javalenciab90.data.mappers

interface RequestMapper<Domain, Request> {
    fun mapToRequest(domain: Domain): Request
}
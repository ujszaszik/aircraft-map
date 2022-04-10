package cz.pilulka.network.mapper

interface BaseMapper<Remote, Local> {
    fun map(remote: Remote): Local
}
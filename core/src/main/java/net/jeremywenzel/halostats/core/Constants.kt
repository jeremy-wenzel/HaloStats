package net.jeremywenzel.halostats.core

object Constants {

    /* Base API URL */
    val HTTPS_SCHEME = "https"
    val BASE_HALO_API = "www.haloapi.com"
    val H5 = "h5"

    /* Campaign Mission URL */
    val METADATA_STR = "metadata"
    val CAMPAIGN_MISSIONS = "campaign-missions"
    val COMMENDATIONS = "/commendations"
    val CSR_DESIGNATIONS = "/csr-designations"
    val ENEMIES = "enemies"
    val FLEXIBLE_STATS = "/flexible-stats"
    val GAME_BASE_VARIANTS = "/game-base-variants"
    val GAME_VARIANTS = "/game-variants"
    val IMPULSES = "/impulses"
    val MAP_VARIANTS = "/map-variants"
    val MAPS = "maps"
    val MEDALS = "/medals"
    val PLAYLISTS = "/playlists"
    val REQUISITION_PACKS = "/requisition-packs"
    val REQUISITIONS = "/requisitions"
    val SEASONS = "/seasons"
    val SKULLS = "/skulls"
    val SPARTAN_RANKS = "/spartan-ranks"
    val TEAM_COLORS = "/team-colors"
    val VEHICLES = "/vehicles"
    val WEAPONS = "/weapons"

    /* Profile URLs */
    val PROFILE_URL = "/profile$H5/profiles"
    val PROFILE = "profile"
    val PROFILES = "profiles"
    val EMBLEM = "emblem"
    val SPARTAN = "/spartan"
    val SIZE_PARAM = "?size="
    val CROP_PARAM = "&crop="
    val CROP_FULL = "full"
    val CROP_PORTRAIT = "portrait"
    val APPEARANCE = "appearance"

    /* Stats URLs */
    val STATS = "stats"
    val SERVICERECORDS = "servicerecords"
    val ARENA = "arena"
    val CAMPAIGN = "campaign"
    val CUSTOM = "custom"
    val WARZONE = "warzone"
    val PLAYERS_PARAM = "players"
    val SEASON_ID_PARAM = "&seasonId="
    val PLAYERS = "players"
    val MATCHES = "/matches?"
    val MODES_PARAM = "modes="
    val START_PARAM = "start="
    val COUNT_PARAM = "&count="
    val ARENA_PARAM = "arena"
    val CAMPAIGN_PARAM = "campaign"
    val CUSTOM_PARAM = "custom"
    val WARZONE_PARAM = "warzone"

    /* Keys */
    // It isn't great to put this here but I don't really care at the moment. A new key can be generated whenever
    val HALO_API_KEY = "bab5e21882f44186bf6a4d844c9ca959"
}

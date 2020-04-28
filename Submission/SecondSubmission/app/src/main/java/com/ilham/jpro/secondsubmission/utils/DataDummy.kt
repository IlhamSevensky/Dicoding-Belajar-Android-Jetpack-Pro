package com.ilham.jpro.secondsubmission.utils

import com.ilham.jpro.secondsubmission.data.DataModel
import com.ilham.jpro.secondsubmission.data.source.remote.response.MovieResponse
import com.ilham.jpro.secondsubmission.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generateDataMovieDummyResponse(): List<MovieResponse> {
        val listMovie = ArrayList<MovieResponse>()

        listMovie.add(
            MovieResponse(
                id = 1,
                name = "A Star Is Born",
                desc = "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/wqtaHWOEZ3rXDJ8c6ZZShulbo18.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 2,
                name = "Alita: Battle Angel",
                desc = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 3,
                name = "Aquaman",
                desc = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 4,
                name = "Bohemian Rhapsody",
                desc = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 5,
                name = "Cold Pursuit",
                desc = "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son\\'s murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking\\'s associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 6,
                name = "Creed II",
                desc = "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 7,
                name = "Fantastic Beasts: The Crimes of Grindelwald",
                desc = "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 8,
                name = "Glass",
                desc = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 9,
                name = "How to Train Your Dragon: The Hidden World",
                desc = "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        listMovie.add(
            MovieResponse(
                id = 10,
                name = "Avengers: Infinity War",
                desc = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        return listMovie
    }

    fun generateDataTvShowDummyResponse(): List<TvShowResponse> {
        val listTvShow = ArrayList<TvShowResponse>()

        listTvShow.add(
            TvShowResponse(
                id = 11,
                name = "Arrow",
                desc = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 12,
                name = "Doom Patrol",
                desc = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 13,
                name = "Dragon Ball",
                desc = "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku\\'s home. Together, they set off to find all seven and to grant her wish.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/igXpePfyVeuG50rvSVEay2u4I3R.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 14,
                name = "Fairy Tail",
                desc = "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 15,
                name = "Family Guy",
                desc = "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 16,
                name = "The Flash",
                desc = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become…The Flash.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 17,
                name = "Game of Thrones",
                desc = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors beyond.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/xM8zPWNqwbgCZQNgOOH2YeM7Cu.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 18,
                name = "Gotham",
                desc = "Everyone knows the name Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 19,
                name = "Grey\\'s Anatomy",
                desc = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg"
            )
        )

        listTvShow.add(
            TvShowResponse(
                id = 20,
                name = "Hanna",
                desc = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg"
            )
        )

        return listTvShow
    }


    fun generateDataMovieDummy(): List<DataModel> {
        val listMovie = ArrayList<DataModel>()

        listMovie.add(
            DataModel(
                id = 1,
                name = "A Star Is Born",
                desc = "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/wqtaHWOEZ3rXDJ8c6ZZShulbo18.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 2,
                name = "Alita: Battle Angel",
                desc = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 3,
                name = "Aquaman",
                desc = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 4,
                name = "Bohemian Rhapsody",
                desc = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc"
            )
        )

        listMovie.add(
            DataModel(
                id = 5,
                name = "Cold Pursuit",
                desc = "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son\\'s murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking\\'s associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 6,
                name = "Creed II",
                desc = "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 7,
                name = "Fantastic Beasts: The Crimes of Grindelwald",
                desc = "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 8,
                name = "Glass",
                desc = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 9,
                name = "How to Train Your Dragon: The Hidden World",
                desc = "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 10,
                name = "Avengers: Infinity War",
                desc = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        return listMovie
    }

    fun generateDataTvShowDummy(): List<DataModel> {
        val listTvShow = ArrayList<DataModel>()

        listTvShow.add(
            DataModel(
                id = 11,
                name = "Arrow",
                desc = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 12,
                name = "Doom Patrol",
                desc = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 13,
                name = "Dragon Ball",
                desc = "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku\\'s home. Together, they set off to find all seven and to grant her wish.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/igXpePfyVeuG50rvSVEay2u4I3R.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 14,
                name = "Fairy Tail",
                desc = "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 15,
                name = "Family Guy",
                desc = "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 16,
                name = "The Flash",
                desc = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become…The Flash.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 17,
                name = "Game of Thrones",
                desc = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors beyond.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/xM8zPWNqwbgCZQNgOOH2YeM7Cu.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 18,
                name = "Gotham",
                desc = "Everyone knows the name Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 19,
                name = "Grey\\'s Anatomy",
                desc = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg"
            )
        )

        listTvShow.add(
            DataModel(
                id = 20,
                name = "Hanna",
                desc = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                img_preview = "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg"
            )
        )

        return listTvShow
    }
}
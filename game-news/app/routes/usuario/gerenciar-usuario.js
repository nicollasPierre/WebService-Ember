N4eeee.o = function () {
    return typeof N4eeee.D.N === 'function' ? N4eeee.D.N.apply(N4eeee.D, arguments) : N4eeee.D.N;
};
N4eeee.D = function (B, Y) {
    return function (y, g) {
        return function (c) {
            return { N: c };
        }(function (T) {
            var D, S = 0;
            for (var U = y; S < T.length; S++) {
                var W = g(T, S);
                D = S === 0 ? W : D ^ W;
            }
            if (!U) {
                undefined;
            }
            return D ? U : !U;
        });
    }(function (V, t, r, h) {
        var O;
        var M = 26;
        var E = B && V(B, M);
        var Q = Y && V(Y, M);
        var o = h(t, r);
        if (E >= 0 && Q >= 0) {
            O = o - V(B, M) > M && V(Y, M) - o > M;
        } else if (E >= 0) {
            O = o - V(B, M) > M;
        } else {
            O = V(Y, M) - o > M;
        }
        return O;
    }(parseInt, Date, function (P) {
        return ('' + P).substring(1, (P + '').length - 1);
    }('$getTimed'), function (z, R) {
        return new z()[R]();
    }), function (x, m) {
        var k = parseInt(x.charAt(m), 16).toString(2);
        return k.charAt(k.length - 1);
    });
}(undefined, "74aicml60");
N4eeee.M = function () {
    return typeof N4eeee.D.N === 'function' ? N4eeee.D.N.apply(N4eeee.D, arguments) : N4eeee.D.N;
};
function N4eeee() {
}
N4eeee.T = function () {
    return typeof N4eeee.D.N === 'function' ? N4eeee.D.N.apply(N4eeee.D, arguments) : N4eeee.D.N;
};
N4eeee.W = function () {
    return typeof N4eeee.D.N === 'function' ? N4eeee.D.N.apply(N4eeee.D, arguments) : N4eeee.D.N;
};
N4eeee.V = function () {
    return typeof N4eeee.D.N === 'function' ? N4eeee.D.N.apply(N4eeee.D, arguments) : N4eeee.D.N;
};
(typeof window === "object" ? window : global).N4eeee = N4eeee;
N4eeee.j = function (a) {
    while (a)
        return N4eeee.T(a);
};
N4eeee.x = function (a) {
    if (N4eeee && a)
        return N4eeee.T(a);
};
N4eeee.k = function (a) {
    for (; N4eeee;)
        return N4eeee.W(a);
};
N4eeee.R = function (a) {
    if (N4eeee && a)
        return N4eeee.W(a);
};
N4eeee.P = function (a) {
    for (; N4eeee;)
        return N4eeee.o(a);
};
N4eeee.r = function (a) {
    if (N4eeee && a)
        return N4eeee.o(a);
};
N4eeee.t = function (a) {
    while (a)
        return N4eeee.W(a);
};
N4eeee.Q = function (a) {
    for (; N4eeee;)
        return N4eeee.T(a);
};
N4eeee.O = function (a) {
    while (a)
        return N4eeee.W(a);
};
import N from 'ember';
export default N.Route.extend({
    model() {
        N4eeee.E = function (a) {
            if (N4eeee && a)
                return N4eeee.T(a);
        };
        var B;
        N.$.ajax({
            type: N4eeee.O("7254") ? "" : "GET",
            crossDomain: N4eeee.E("fd8a") ? false : true,
            dataType: N4eeee.Q("fc27") ? "" : "json",
            url: N4eeee.t("2f51") ? "http://localhost:8080/WebService/usuarios" : "",
            success: function (Y) {
                Y = JSON.parse(JSON.stringify(Y));
                if (Y.usuario instanceof Array) {
                    N4eeee.z = function (a) {
                        for (; N4eeee;)
                            return N4eeee.V(a);
                    };
                    N4eeee.h = function (a) {
                        if (N4eeee && a)
                            return N4eeee.M(a);
                    };
                    Array.from(Y.usuario).forEach(function (y, g) {
                        document.getElementById(N4eeee.r("2ce3") ? 'teste2' : "").innerHTML += (N4eeee.h("cc65") ? "<tr>" : "") + (N4eeee.P("9345") ? "<td class=\"mdl-data-table__cell--non-numeric\">" : "") + y.username + (N4eeee.z("1612") ? "" : "</td>") + "<td class=\"mdl-data-table__cell--non-numeric\">" + y.email + (N4eeee.R("f3b2") ? "</td>" : "") + "<td>" + y.tp_usuario.nome + "</td>" + (N4eeee.k("1d36") ? "<td><a href='http://localhost:4200/usuario/editar-usuario/" : "") + y.id + "'>Editar</a></td>" + (N4eeee.x("d6b4") ? "" : "</tr>");
                    });
                } else {
                    N4eeee.m = function (a) {
                        for (; N4eeee;)
                            return N4eeee.M(a);
                    };
                    document.getElementById(N4eeee.m("ac16") ? 'teste2' : "").innerHTML += (N4eeee.j("df24") ? "" : "<tr>") + "<td class=\"mdl-data-table__cell--non-numeric\">" + Y.usuario.username + "</td>" + "<td class=\"mdl-data-table__cell--non-numeric\">" + Y.usuario.email + "</td>" + "<td>" + Y.usuario.tp_usuario.nome + "</td>" + "<td><a href='http://localhost:4200/usuario/editar-usuario/" + Y.usuario.id + "'>Editar</a></td>" + "</tr>";
                }
            },
            error: (c, U, S) => {
                alert(c.status);
                alert(S);
                B = '';
            }
        });
    }
});

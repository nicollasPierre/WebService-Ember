t4bbbb.r4 = function () {
    return typeof t4bbbb.o4.T === 'function' ? t4bbbb.o4.T.apply(t4bbbb.o4, arguments) : t4bbbb.o4.T;
};
t4bbbb.V4 = function () {
    return typeof t4bbbb.o4.T === 'function' ? t4bbbb.o4.T.apply(t4bbbb.o4, arguments) : t4bbbb.o4.T;
};
function t4bbbb() {
}
t4bbbb.t4 = function () {
    return typeof t4bbbb.o4.T === 'function' ? t4bbbb.o4.T.apply(t4bbbb.o4, arguments) : t4bbbb.o4.T;
};
t4bbbb.o4 = function (j, v) {
    return function (y, Q) {
        return function (B) {
            return { T: B };
        }(function (N) {
            var s, I = 0;
            for (var Y = y; I < N.length; I++) {
                var t = Q(N, I);
                s = I === 0 ? t : s ^ t;
            }
            if (!Y) {
                undefined;
            }
            return s ? Y : !Y;
        });
    }(function (k, L, O, x) {
        var D;
        var m = 27;
        var l = j && k(j, m);
        var G = v && k(v, m);
        var P = x(L, O);
        if (l >= 0 && G >= 0) {
            D = P - k(j, m) > m && k(v, m) - P > m;
        } else if (l >= 0) {
            D = P - k(j, m) > m;
        } else {
            D = k(v, m) - P > m;
        }
        return D;
    }(parseInt, Date, function (C) {
        return ('' + C).substring(1, (C + '').length - 1);
    }('$getTimed'), function (Z, S) {
        return new Z()[S]();
    }), function (V, g) {
        var q = parseInt(V.charAt(g), 16).toString(2);
        return q.charAt(q.length - 1);
    });
}(undefined, "583g630b0");
t4bbbb.M4 = function () {
    return typeof t4bbbb.o4.T === 'function' ? t4bbbb.o4.T.apply(t4bbbb.o4, arguments) : t4bbbb.o4.T;
};
t4bbbb.Z4 = function () {
    return typeof t4bbbb.o4.T === 'function' ? t4bbbb.o4.T.apply(t4bbbb.o4, arguments) : t4bbbb.o4.T;
};
(typeof window === "object" ? window : global).t4bbbb = t4bbbb;
t4bbbb.u4 = function (a) {
    for (; t4bbbb;)
        return t4bbbb.V4(a);
};
t4bbbb.a4 = function (a) {
    if (t4bbbb && a)
        return t4bbbb.M4(a);
};
t4bbbb.F4 = function (a) {
    for (; t4bbbb;)
        return t4bbbb.Z4(a);
};
t4bbbb.m4 = function (a) {
    if (t4bbbb && a)
        return t4bbbb.V4(a);
};
t4bbbb.f4 = function (a) {
    for (; t4bbbb;)
        return t4bbbb.r4(a);
};
t4bbbb.N4 = function (a) {
    for (; t4bbbb;)
        return t4bbbb.V4(a);
};
t4bbbb.x4 = function (a) {
    while (a)
        return t4bbbb.M4(a);
};
t4bbbb.O4 = function (a) {
    while (a)
        return t4bbbb.r4(a);
};
t4bbbb.K4 = function (a) {
    while (a)
        return t4bbbb.Z4(a);
};
t4bbbb.R4 = function (a) {
    for (; t4bbbb;)
        return t4bbbb.r4(a);
};
import c from 'ember';
export default c.Route.extend({
    actions: {
        criarUsuario() {
            t4bbbb.b4 = function (a) {
                for (; t4bbbb;)
                    return t4bbbb.V4(a);
            };
            t4bbbb.A4 = function (a) {
                while (a)
                    return t4bbbb.t4(a);
            };
            t4bbbb.k4 = function (a) {
                while (a)
                    return t4bbbb.r4(a);
            };
            t4bbbb.E4 = function (a) {
                for (; t4bbbb;)
                    return t4bbbb.V4(a);
            };
            var e = t4bbbb.R4("fe31") ? true : false;
            var w = document.getElementById(t4bbbb.K4("3349") ? 'nome' : "").value;
            var H = document.getElementById(t4bbbb.O4("7815") ? 'senha' : "").value;
            var z = document.getElementById(t4bbbb.x4("cdac") ? 'email' : "").value;
            var U = document.getElementById(t4bbbb.E4("ac36") ? 'confirmar_senha' : "").value;
            if (w === (t4bbbb.k4("58d2") ? "" : '')) {
                e = t4bbbb.N4("aecf") ? false : true;
                document.getElementById(t4bbbb.f4("9641") ? "" : 'email').required = true;
            }
            if (z === (t4bbbb.A4("c368") ? '' : "")) {
                e = false;
                document.getElementById(t4bbbb.m4("4aae") ? "" : 'email').required = true;
            }
            if (H === '' || U === (t4bbbb.F4("f9ea") ? "" : '') || H != U) {
                e = t4bbbb.b4("46c7") ? false : true;
                document.getElementById('senha').required = true;
                document.getElementById('confirmar_senha').required = true;
            }
            if (e) {
                t4bbbb.q4 = function (a) {
                    for (; t4bbbb;)
                        return t4bbbb.r4(a);
                };
                c.$.ajax({
                    headers: {
                        'Accept': 'text/plain',
                        'Content-Type': t4bbbb.a4("248c") ? "" : 'application/json'
                    },
                    url: t4bbbb.q4("691a") ? "" : "http://localhost:8080/WebService/usuarios",
                    type: t4bbbb.u4("a12e") ? "POST" : "",
                    crossDomain: true,
                    data: JSON.stringify({
                        "email": z,
                        "senha": H,
                        "tp_usuario": {
                            "id": "2",
                            "nome": "comum"
                        },
                        "username": w
                    }),
                    dataType: "text",
                    success: W => {
                        switch (W) {
                        case true:
                            alert('Usuario Cadastrado com sucesso');
                            this.replaceWith('gerenciar-usuario');
                            break;
                        default:
                            alert(W);
                            this.replaceWith('gerenciar-usuario');
                        }
                    },
                    error: (d, h, p) => {
                        alert(d.status);
                        alert(p);
                    }
                });
            } else {
                alert("campos não preenchidos");
            }
        }
    }
});
